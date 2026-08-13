import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[] arr = new int[501];

    public static int[][][] dp = new int[501][5][101]; // 인덱스 순서, 들어갈 숫자, 다른 횟수 = 점수

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= 4; j++) {
                for(int k = 0; k <= m; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        for(int i = 1; i <= 4; i++) {
            dp[0][i][0] = 0;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= 4; j++) {
                for(int k = 0; k <= m; k++) {
                    if(dp[i][j][k] < 0) continue;

                    for(int idx = 1; idx <= 4; idx++) {
                        int val = 0;
                        if(idx == arr[i + 1]) val = 1;
                        if(idx == j) dp[i + 1][idx][k] = Math.max(dp[i + 1][idx][k], dp[i][j][k] + val);

                        else if(idx != j && k < m) dp[i + 1][idx][k + 1] = Math.max(dp[i + 1][idx][k + 1], dp[i][j][k] + val);
                    }
                }
            }
        }

        int ans = 0;
        for(int i = 1; i <= 4; i++) {
            for(int j = 0; j <= m; j++) {
                ans = Math.max(dp[n][i][j], ans);
            }
        }
        System.out.print(ans);
    }
}