import java.io.*;
import java.util.*;

public class Main {
    public static int t, n, m;
    public static int[][] grid;
    public static int[][] dir;
    public static int[][] count;
    public static int[][] nextDir;

    public static int[] dx = {1, 0, -1, 0};  // (+ 2 % 4)
    public static int[] dy = {0, 1, 0, -1}; // D, R, U, L

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int o = 0; o < t; o++) {

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            grid = new int[n][n];   // 현재 좌표
            dir = new int[n][n];    // 방향 표시


            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                char ch = st.nextToken().charAt(0);

                grid[x][y] = 1;

                if(ch == 'D') dir[x][y] = 0;
                else if(ch == 'R') dir[x][y] = 1;
                else if(ch == 'U') dir[x][y] = 2;
                else dir[x][y] = 3;
            }

            for(int i = 0; i < 2*n; i++) {
                count = new int[n][n];  // 이동한 좌표
                nextDir = new int[n][n];

                for(int q = 0; q < n; q++) {
                    for(int w = 0; w < n; w++) {
                        int nx, ny;
                        if(grid[q][w] == 1) {
                            nx = q + dx[dir[q][w]];
                            ny = w + dy[dir[q][w]];

                            if(inRange(nx, ny)) {
                                count[nx][ny]++;
                                nextDir[nx][ny] = dir[q][w];
                            }
                            else {
                                nextDir[q][w] = (dir[q][w] + 2) % 4;
                                count[q][w]++;
                            }
                        }
                    }
                }

                for(int q = 0; q < n; q++) {
                    for(int w = 0; w < n; w++) {
                        if(count[q][w] <= 1) {
                            grid[q][w] = count[q][w];
                            dir[q][w] = nextDir[q][w];
                        }
                        else {
                            grid[q][w] = 0;
                        }
                    }
                }
            }

            int cnt = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == 1) cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}