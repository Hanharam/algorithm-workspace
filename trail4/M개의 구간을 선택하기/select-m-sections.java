import java.io.*;
import java.util.*;

public class Main {
    public static final int MIN_NUM = -1000000000;
    public static int n, m;
    public static int[] a = new int[501];
    public static int[][][] dp = new int[501][251][2];

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                dp[i][j][0] = MIN_NUM;
                dp[i][j][1] = MIN_NUM;
            }
        }

        for(int i = 0; i <= n; i++) {
            dp[i][0][0] = 0;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                
                // 미포함
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1]);

                // 포함
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0]) + a[i];

            }
        }

        System.out.print(Math.max(dp[n][m][1], dp[n][m][0]));
    }
}