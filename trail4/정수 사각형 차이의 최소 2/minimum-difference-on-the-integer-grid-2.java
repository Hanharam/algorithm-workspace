import java.io.*;
import java.util.*;

public class Main {
    public static final int INF = Integer.MAX_VALUE;

    public static int n;
    public static int[][] grid = new int[100][100];
    public static int[][] dp = new int[100][100];

    public static int ans = INF;

    public static void initialize() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = INF;
            }
        }

        dp[0][0] = grid[0][0];

        for(int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], grid[i][0]);
            dp[0][i] = Math.max(dp[0][i - 1], grid[0][i]);
        }
    }

    public static int solve(int low) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] < low) {
                    grid[i][j] = INF;
                }
            }
        }

        initialize();

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = Math.max(
                    Math.min(dp[i - 1][j], dp[i][j - 1]),
                    grid[i][j]
                );
            }
        }

        return dp[n - 1][n - 1];
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int low = 1; low <= 100; low++) {
            int upper = solve(low);

            if(upper == INF) {
                continue;
            }

            ans = Math.min(ans, upper - low);
        }

        System.out.print(ans);
        
    }
}