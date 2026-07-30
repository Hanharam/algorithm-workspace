import java.io.*;
import java.util.*;

public class Main {
    public static int n;

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = grid[0][0];
        for(int i = 1; i < n; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!inRange(i - 1, j) || !inRange(i, j - 1)) continue;
                dp[i][j] = Math.max(dp[i][j - 1] + grid[i][j] , dp[i - 1][j] + grid[i][j]);
            }
        }

        System.out.print(dp[n - 1][n - 1]);

    }
}