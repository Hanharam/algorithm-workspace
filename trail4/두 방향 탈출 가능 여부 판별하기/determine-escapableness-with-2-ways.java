import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] grid;
    public static boolean canEscape = false;
    public static boolean[][] visited;

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    public static boolean canGo(int x, int y) {
        return inRange(x, y) && grid[x][y] == 1 && !visited[x][y];
    }

    public static void DFS(int x, int y) {
        if(x == n - 1 && y == m - 1) {
            canEscape = true;
            return;
        }
        if(canEscape) return;

        int[] dx = {1, 0};
        int[] dy = {0, 1};

        for(int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(canGo(nx, ny)) {
                visited[nx][ny] = true;
                DFS(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        grid = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0, 0);
        if(canEscape) System.out.print(1);
        else System.out.print(0);
    }
}