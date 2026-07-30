import java.io.*;
import java.util.*;

public class Main {
    public static int n;

    public static int[][] grid = new int[100][100];
    public static int[][] dp = new int[100][100];

    public static int answer = 0;

    public static void initialize() {
        dp[0][0] = grid[0][0];

        for(int i = 1; i < n; i++) {
            dp[0][i] = Math.min(grid[0][i], dp[0][i - 1]);
        }

        for(int i = 1; i < n; i++) {
            dp[i][0] = Math.min(grid[i][0], dp[i - 1][0]);
        }
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

        initialize();

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = Math.min(grid[i][j], Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }

        System.out.print(dp[n - 1][n - 1]);
    }
}