import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, r, c;
    public static int[][] grid;

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y < n && y >= 0);
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;

        grid = new int[n][n];
        int[][] temp = new int[n][n];

        grid[r][c] = 1;
        temp[r][c] = 1;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int range = 1;

        for(int i = 1; i <= m; i++) {

            for(int l = 0; l < n; l++) {
                for(int k = 0; k < n; k++) {
                    if(grid[l][k] == 1) {


                        for(int q = 0; q < 4; q++) {

                            if(inRange(l + range*dx[q] , k + range*dy[q])) {
                                temp[l + range*dx[q]][k + range*dy[q]] = 1;
                            }
                        }
                    }
                }
            }
            range = range * 2;

            for(int p = 0; p < n; p++) {
                for(int j = 0; j < n; j++) {
                    grid[p][j] = temp[p][j];
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) ans++;
            }
        }
        System.out.print(ans);
    }
}