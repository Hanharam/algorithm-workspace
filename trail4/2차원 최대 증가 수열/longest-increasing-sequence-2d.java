import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] grid = new int[50][50];
    public static int[][] dp = new int[50][50];

    public static void initialize() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = 1;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        initialize();

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {

                for(int k = 0; k < i; k++) {
                    for(int l = 0; l < j; l++) {
                        if(dp[k][l] == Integer.MIN_VALUE) continue;
                        
                        if(grid[i][j] > grid[k][l]) {
                            dp[i][j] = Math.max(dp[i][j], dp[k][l] + 1);
                        }
                    }
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        System.out.print(ans);
    }
}