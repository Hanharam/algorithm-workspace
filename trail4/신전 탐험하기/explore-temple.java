import java.io.*;
import java.util.*;

public class Main {
    public static int n;

    public static int[][] gems = new int[1001][3];
    public static int[][] dp = new int[1001][3]; // 0 : l, 1 : m, 2 : r

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n ;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                gems[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 3; i++) {
            dp[1][i] = gems[1][i];
        }
        
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    if(j == k) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + gems[i][j]);
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < 3; i++) {
            ans = Math.max(dp[n][i], ans);
        }
        System.out.print(ans);
    }
}