import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[][] grid;

    public static int[] dx = {1, 0, -1, 0}; // D, L, U, R
    public static int[] dy = {0, -1, 0, 1}; // '\' 0 -> 3, 1 -> 2 == {3 - dir}
                                            // '/' 0 -> 1, 2 -> 3 == (dir ^ 1)

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
    
    public static int findPath(int x, int y, int dir) {
        boolean done = false;
        int cnt = 0;
        int nx = x;
        int ny = y;


        do {
            nx += dx[dir];
            ny += dy[dir];
            cnt++;
            if(!inRange(nx, ny)) break;
            
            if(grid[nx][ny] == 2) {
                dir = 3 - dir;
            }
            else if(grid[nx][ny] == 1) {
                dir = dir ^ 1;
            }

            x = nx;
            y = ny;

        } while(!done);

        return cnt;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n]; 


        StringTokenizer st;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, Math.max(findPath(-1, i, 0), Math.max(findPath(i, -1, 3), Math.max(findPath(i, n, 1), findPath(n, i, 2)))));
        }

        System.out.print(ans);
    }
}