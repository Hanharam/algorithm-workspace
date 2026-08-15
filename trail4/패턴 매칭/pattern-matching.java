import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;

    public static char[] s;
    public static char[] p;

    public static boolean[][] dp = new boolean[21][21];

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = (" " + br.readLine()).toCharArray();
        p = (" " + br.readLine()).toCharArray();

        n = s.length - 1;
        m = p.length - 1;

        dp[0][0] = true;

        for(int j = 2; j <= m; j++) {
            if(p[j] == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                
                // 일반 문자, '.'
                if(p[j] != '*') {
                    if(p[j] == '.' || p[j] == s[i]) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }

                // '*'
                else {
                    // 한 번도 사용안 한 경우
                    dp[i][j] = dp[i][j - 2];

                    // 1번 이상 사용한 경우
                    if(p[j - 1] == '.' || p[j - 1] == s[i]) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }
        System.out.print(dp[n][m]);
    }
}

