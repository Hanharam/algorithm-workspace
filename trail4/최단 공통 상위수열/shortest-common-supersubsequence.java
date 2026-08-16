import java.io.*;
import java.util.*;

public class Main {
    public static char[] a;
    public static char[] b;

    public static int[][] dp = new int[1001][1001];

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = (" " + br.readLine()).toCharArray();
        b = (" " + br.readLine()).toCharArray();

        int n = a.length - 1;
        int m = b.length - 1;

        dp[0][0] = 0;
        for(int i = 1; i <= n; i++) {
            // if(a[i] == a[i - 1]) dp[i][0] = dp[i - 1][0];
            dp[i][0] = dp[i - 1][0] + 1;
        }

        for(int i = 1; i <= m; i++) {
            // if(b[i] == b[i - 1]) dp[0][i] = dp[0][i - 1];
            dp[0][i] = dp[0][i - 1] + 1;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {

                if(a[i] == b[j]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
            }
        }
        System.out.print(dp[n][m]);
    }
}