import java.io.*;
import java.util.*;

class Quest {
    int e, t;

    public Quest(int e, int t) {
        this.e = e;
        this.t = t;
    }
}

public class Main {
    public static int n, m;
    public static Quest[] quests = new Quest[100];
    public static int maxTime;

    // i번째 원소까지 골라봤을 때 시간별 최대 경험치 수
    public static int[][] dp = new int[101][10001];

    public static void init() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= maxTime; j++) {
                dp[i][j] = -1;
            }
        }

        dp[0][0] = 0;
        dp[0][quests[0].t] = quests[0].e;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            quests[i] = new Quest(e, t);
            maxTime += t;
        }

        init();

        for(int i = 1; i < n; i++) {
            int e = quests[i].e;
            int t = quests[i].t;

            for(int j = 0; j <= maxTime; j++) {
                
                // 퀘스트 O
                if(j >= t && dp[i - 1][j - t] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - t] + e);
                }

                // 퀘스트 X
                if(dp[i - 1][j] != -1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
                }
            }
        }

        int ans = -1;
        for(int i = 1; i <= maxTime; i++) {
            if(dp[n - 1][i] >= m) {
                ans = i;
                break;
            }
        } 

        // for(int i = 1; i <= maxTime; i++) {
        //     System.out.print(dp[n - 1][i] + " ");
        // } 
        // System.out.println();

        System.out.print(ans);
    }
}