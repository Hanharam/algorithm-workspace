import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] grid;

    public static int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
    public static int[] dy = {1, 0, -1, 1, 0, -1, 1, -1};

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int size = n*n;

        grid = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < m; i++) {    // m 번 진행

            for(int j = 1; j <= size; j++) {    // 1 ~ n*n 옮기기
                int x = 0;
                int y = 0;

                for(int g = 0; g < n; g++) {
                    for(int h = 0; h < n; h++) {    // 숫자 위치 찾기
                        if(grid[g][h] == j) {
                            x = g;
                            y = h;
                        }
                    }
                }
                            int max = 0;
                            int nx, ny;
                            int maxX = x;
                            int maxY = y;

                            for(int z = 0; z < 8; z++) { // 8방향 탐색
                                nx = x + dx[z];
                                ny = y + dy[z];

                                if(inRange(nx, ny) && max < grid[nx][ny]) {
                                    max = grid[nx][ny];
                                    maxX = nx;
                                    maxY = ny;
                                }
                            }

                            int temp = grid[x][y];
                            grid[x][y] = grid[maxX][maxY];
                            grid[maxX][maxY] = temp;                        
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}