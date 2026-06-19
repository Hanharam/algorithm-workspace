import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n &&  y >= 0 && y < m);
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        char[][] grid = new char[n][m];

        int x = 0;
        int y = 0;
        int dir = 0;
        char curChar = 'A';

        for(int i = 0; i < n*m; i++) {

            grid[x][y] = curChar;

            curChar++;

            if(curChar > 'Z') curChar = 'A';

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(!inRange(nx, ny) || grid[nx][ny] != '\0'){
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}