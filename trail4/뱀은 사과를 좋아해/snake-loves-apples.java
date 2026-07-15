import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, k;
    public static int[][] grid;

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        grid = new int[n][n]; // 1 : snake, 2 : apple

        grid[0][0] = 1;

        int[] dx = {1, 0, -1, 0}; // D, R, U, L
        int[] dy = {0, 1, 0, -1};

        int length = 1;

        int x = 0;
        int y = 0;

        int[] queueX = new int[10000];
        int[] queueY = new int[10000];
        int headX = 0;
        int headY = 0;
        int rearX = 0;
        int rearY = 0;

        queueX[headX++] = 0;
        queueY[headY++] = 0;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int posX = Integer.parseInt(st.nextToken()) - 1;
            int posY = Integer.parseInt(st.nextToken()) - 1;

            grid[posX][posY] = 2;
        }


        boolean isOver = false;
        int timer = 0;
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());
            int dir = 0;

            if(ch == 'D') dir = 0;
            if(ch == 'R') dir = 1;
            if(ch == 'U') dir = 2;
            if(ch == 'L') dir = 3;

            for(int j = 0; j < num; j++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                timer++;

                if(!inRange(nx, ny)) {
                    isOver = true;
                    break;
                }
                else if(grid[nx][ny] == 1 && (nx != queueX[rearX] || ny != queueY[rearY])) {
                    isOver = true;
                    break;
                }
                else if(grid[nx][ny] == 2) {
                    grid[nx][ny] = 1;
                    x = nx;
                    y = ny;
                    queueX[headX++] = x;
                    queueY[headY++] = y;
                }
                else {
                    x = nx;
                    y = ny;
                    grid[queueX[rearX++]][queueY[rearY++]] = 0;
                    grid[nx][ny] = 1;
                    queueX[headX++] = x;
                    queueY[headY++] = y;
                }
            }

            if(isOver) break;
        }

        System.out.print(timer);
    }
}