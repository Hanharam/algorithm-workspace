import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0}; // E, S, W, N


        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n][m];


        int dir = 1;
        int x = -1;
        int y = 0;

        for(int i = 1; i <= n*m; i++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(inRange(nx, ny) && grid[nx][ny] == 0) {
                x = nx;
                y = ny;

                grid[x][y] = i;
            }
            else {
                dir = (dir - 1 + 4) % 4;
                x += dx[dir];
                y += dy[dir];

                grid[x][y] = i;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}