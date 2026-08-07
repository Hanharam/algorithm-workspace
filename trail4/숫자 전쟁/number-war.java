import java.io.*;
import java.util.*;

public class Main {
    public static int n, maxScore;
    public static int[] p1 = new int[1001];
    public static int[] p2 = new int[1001];

    public static int[][] dp = new int[1001][1001];

    public static void init() {
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            p1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            p2[i] = Integer.parseInt(st.nextToken());
        }

        init();

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if(dp[i][j] == -1) continue;

                maxScore = Math.max(maxScore, dp[i][j]);

                if(i < n && j < n) {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j]);

                    if(p1[i] > p2[j]) {
                        dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i][j] + p2[j]);
                    }
                    else if(p1[i] < p2[j]) {
                        dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
                    }
                    else {
                        dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j]);
                    }
                }
            }
        }

        System.out.print(maxScore);
    }
}