import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, t;
    public static int[][] grid;
    public static int[][] count;
    public static int[][] nextCnt;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        count = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            count[r][c] = 1;
        };

        for(int i = 0; i < t; i++) { // t번 진행
            nextCnt = new int[n][n];

            for(int l = 0; l < n; l++) {
                for(int m = 0; m < n; m++) { // (l, m) 칸 옮기기

                    if(count[l][m] != 1) continue; // 구슬 존재 여부 확인

                    int nx, ny;
                    int maxX = l;
                    int maxY = m;
                    int maxNum = 0;

                    for(int q = 0; q < 4; q++) { // 상하좌우 큰 값 있는지 확인
                        nx = l + dx[q];
                        ny = m + dy[q];

                        if(inRange(nx, ny) && maxNum < grid[nx][ny]) { // 범위 안에 있거나 원래 값보다 클 경우에 이동
                                maxX = nx;
                                maxY = ny;
                                maxNum = grid[nx][ny];                         
                        }
                    }
                    nextCnt[maxX][maxY]++;
                }
            }

            // nextCnt 배열에 저장한 구슬의 위치 count 배열로 옮기기
            for(int q = 0; q < n; q++) {
                for(int w = 0; w < n; w++) {
                    if(nextCnt[q][w] >= 2) {
                        nextCnt[q][w] = 0;
                    }
                    count[q][w] = nextCnt[q][w];
                }
            }
        }
        
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(count[i][j] == 1) cnt++;
            }
        }
        System.out.print(cnt);
    }
}