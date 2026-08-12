import java.io.*;
import java.util.*;

public class Main {
    public static final int MOD = 1000000007;
    public static int n;
    public static int[][] dp;

    public static void init() {
        for(int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][10];

        init();

        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= 9; j++) {
                if(i == 1 && j == 0) continue;
                if(j - 1 >= 0) dp[i + 1][j - 1] = (dp[i + 1][j - 1] + dp[i][j]) % MOD;
                if(j + 1 <= 9) dp[i + 1][j + 1] = (dp[i + 1][j + 1] + dp[i][j]) % MOD;
            }
        }

        int ans = 0;
        for(int i = 0; i <= 9; i++) {
            ans = (ans + dp[n][i]) % MOD;
        }
        System.out.print(ans);
    }
}