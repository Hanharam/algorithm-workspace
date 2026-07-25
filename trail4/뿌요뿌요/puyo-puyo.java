import java.io.*;
import java.util.*;

public class Main {
    public static int n, size;
    public static int[][] grid;
    public static boolean[][] visited;

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static boolean canGo(int x, int y, int val) {
        if(!inRange(x, y)) return false;
        if(grid[x][y] != val || visited[x][y]) return false;
        return true;
    }

    public static void DFS(int x, int y) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(canGo(nx, ny, grid[x][y])) {
                visited[nx][ny] = true;
                size++;
                DFS(nx, ny);
            }
        }
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

        int count = 0;
        int maxSize = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    size = 1;
                    DFS(i, j);

                    if(size >= 4) count++;
                    maxSize = Math.max(size, maxSize);
                }
            }
        }

        System.out.print(count + " " + maxSize);
    }
}