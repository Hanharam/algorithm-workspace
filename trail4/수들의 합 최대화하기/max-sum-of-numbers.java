import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[][] grid;
    public static int ans = Integer.MIN_VALUE;

    public static boolean[][] visited;

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static boolean canPaint(int col) {
        for(int i = 0; i < n; i++) {
            if(visited[i][col] == true) return false;
        }
        return true;
    }

    public static void choose(int row, int value) {
        if(row == n) {
            ans = Math.max(ans, value);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(canPaint(i)) {
                visited[row][i] = true;
                choose(row + 1, value + grid[row][i]);
                visited[row][i] = false;
            }
        }
        return;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        grid = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        choose(0, 0);
        System.out.print(ans);
    }
}