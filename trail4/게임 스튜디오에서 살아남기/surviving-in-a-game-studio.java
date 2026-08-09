import java.io.*;
import java.util.*;

public class Main {
    public static int n;

    // 일 수, B 개수, T 개수
    public static int[][][] dp = new int[1001][4][4];
    public static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp[0][0][0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    if(dp[i][j][k] == 0) continue;

                    // case: 'G'
                    dp[i + 1][0][k] = (dp[i + 1][0][k] + dp[i][j][k]) % MOD;

                    // case: 'B'
                    dp[i + 1][j + 1][k] = (dp[i + 1][j + 1][k] + dp[i][j][k]) % MOD;
                    
                    // case: 'T'
                    dp[i + 1][0][k + 1] = (dp[i + 1][0][k + 1] + dp[i][j][k]) % MOD;
                }
            }
        }

        int ans = 0;
        for(int j = 0; j <= 2; j++) {
            for(int k = 0; k <= 2; k++) {
                ans = (ans + dp[n][j][k]) % MOD;
            }
        }

        System.out.print(ans);
    }
}