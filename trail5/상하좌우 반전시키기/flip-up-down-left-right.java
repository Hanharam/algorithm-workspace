import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[][] grid;

    public static int[] dx = {1, 0, -1, 0, 0};
    public static int[] dy = {0, 1, 0, -1, 0};

    public static void print() {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean inRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= n;
    }

    public static void reverse(int x, int y) {
        for(int i = 0; i < 5; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(inRange(nx, ny)) grid[nx][ny] ^= 1;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        grid = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(grid[i - 1][j] == 0) {
                    reverse(i, j);
                    ans++;
                    // print();
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            if(grid[n][i] == 0) {
                ans = -1;
                break;
            }
        }
        System.out.print(ans); 
    }
}
