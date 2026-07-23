import java.io.*;
import java.util.*;

public class Main {
    public static int n, answer;
    public static int r, c;

    public static int[][] grid;
    public static int[][] direction;

    public static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {0, 0, 1, 1, 1, 0, -1, -1, -1};

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static void choose(int x, int y, int cnt) {
        answer = Math.max(cnt, answer);

        int dir = direction[x][y];
        int nx = x;
        int ny = y;
        int currentValue = grid[x][y];

        while(true) {
            nx = nx + dx[dir];
            ny = ny + dy[dir];

            if(!inRange(nx, ny)) break;

            if(grid[nx][ny] > currentValue) {
                choose(nx, ny, cnt + 1);
            }
        }
        return;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        grid = new int[n][n];
        direction = new int[n][n];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                direction[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;

        choose(r, c, 0);

        System.out.print(answer);
    }
}