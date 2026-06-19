import java.io.*;
import java.util.*;

public class Main {

    public static boolean inRange(int x, int y, int n) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dx = new int[]{0, 1, 0, -1}; // E, S, W, N
        int[] dy = new int[]{1, 0, -1, 0};

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] grid = new boolean[n][n];
        int painted;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            grid[x][y] = true;

            painted = 0;
            for(int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if(inRange(nx, ny, n) && grid[nx][ny]) painted++;
            }

            if(painted == 3) System.out.println(1);
            else System.out.println(0);
        }
    }
}