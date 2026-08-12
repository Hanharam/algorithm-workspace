import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[][] gems = new int[1001][3];

    public static int[][][] dp = new int[1001][3][3];

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                gems[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = -1; 
                }
            }
        }

        for(int i = 0; i < 3; i++) {
            dp[1][i][i] = gems[1][i];
        }


        for(int i = 2; i <= n; i++) {
            for(int l = 0; l < 3; l++) {
                for(int k = 0; k < 3; k++) {
                    for(int start = 0; start < 3; start++) {
                        if(l == k) continue;
                        if(i == n && start == l) continue; 

                        if(dp[i - 1][k][start] == -1)  continue;
                        
                        dp[i][l][start] = Math.max(dp[i][l][start], dp[i - 1][k][start] + gems[i][l]);
                    }
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                ans = Math.max(dp[n][i][j], ans);
            }
        }
        System.out.print(ans);
    }
}