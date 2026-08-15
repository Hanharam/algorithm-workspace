import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static char[] a = new char[1001];
    public static char[] b = new char[1001];

    public static int[][] dp = new int[1001][1001];

    public static void init() {
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = (" " + br.readLine()).toCharArray();
        b = (" " + br.readLine()).toCharArray();

        n = a.length - 1;
        m = b.length - 1;

        init();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(a[i] == b[j]) dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.min(
                        dp[i - 1][j - 1],  // 변경
                        Math.min(
                            dp[i - 1][j],  // 삭제
                            dp[i][j - 1]   // 삽입
                        )
                    ) + 1;
                }
            }
        }

        System.out.print(dp[n][m]);
    }
}