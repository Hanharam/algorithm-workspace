import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] gem;
    public static int[][] dp;

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        gem = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++) {
                gem[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }

        for(int i = 1; i <= m; i++) {
            dp[1][i] = gem[1][i];
        }

        for(int i = 1; i < n; i++) { // 현재층수
            for(int j = 1; j <= m ; j++) { // 현재 방 번호

                for(int l = 1; l <= m; l++) {   // 다음 방 번호
                    if(l == j) continue;

                    dp[i + 1][l] = Math.max(dp[i + 1][l], dp[i][j] + gem[i + 1][l]);
                }

            }
        }

        int ans = 0;
        for(int i = 0; i <= m ; i++) {
            ans = Math.max(dp[n][i], ans);
        }
        System.out.print(ans);
    }
}