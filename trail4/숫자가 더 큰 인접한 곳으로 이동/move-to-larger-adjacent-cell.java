import java.io.*;
import java.util.*;

public class Main {
    public static int n;

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;

        int[][] grid = new int[n][n];

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean isDone;
        int[] ans = new int[n*n];
        ans[0] = grid[x][y];
        int cnt = 1;

        do {
            int nx;
            int ny;
            isDone = false;
            for(int j = 0; j < 4; j++) {
                nx = x + dx[j];
                ny = y + dy[j];

                if(inRange(nx, ny) && grid[x][y] < grid[nx][ny]) {
                    x = nx;
                    y = ny;
                    ans[cnt++] = grid[x][y];
                    isDone = true;
                    break;
                }
            }
        } while(isDone);

        for(int i = 0; i < cnt; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}