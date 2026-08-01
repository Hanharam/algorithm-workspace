import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[][] grid = new int[100][100];

    public static int answer = Integer.MAX_VALUE;

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
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
        
        int answer = Integer.MAX_VALUE;

        for(int low = 1; low <= 100; low++) {
            int[][] dp = new int[n][n];

            for(int i = 0; i < n; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }

            if(grid[0][0] < low) {
                continue;
            }

            dp[0][0] = grid[0][0];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(i == 0 && j == 0) {
                        continue;
                    }

                    if(grid[i][j] < low) {
                        continue;
                    }

                    int prev = Integer.MAX_VALUE;

                    if(i > 0) {
                        prev = Math.min(prev, dp[i - 1][j]);
                    }

                    if(j > 0) {
                        prev = Math.min(prev, dp[i][j - 1]);
                    }

                    if(prev != Integer.MAX_VALUE) {
                        dp[i][j] = Math.max(prev, grid[i][j]);
                    }
                }
            }

            if(dp[n - 1][n - 1] != Integer.MAX_VALUE) {
                answer = Math.min(answer, dp[n - 1][n - 1] - low);
            }
        }

        System.out.print(answer);
    }
}