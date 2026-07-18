import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;

    public static int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
    public static int[] dy = {1, -1, 0, 1, -1, 0, 1, -1};

    public static Deque<Integer>[][] grid;

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new Deque[n][n];

        int size = n*n;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = new ArrayDeque<>();
                grid[i][j].push(Integer.parseInt(st.nextToken()));
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int number = Integer.parseInt(st.nextToken());

            int x = -1, y = -1;
            
            for(int l = 0; l < n; l++) {    // 바꾸려는 숫자 위치 찾기
                for(int k = 0; k < n; k++) {
                    for(int num : grid[l][k]) {
                        if(num == number) {
                            x = l;
                            y = k;
                            break;
                        }
                    }
                }
            }

            int maxX = -1;
            int maxY = -1;
            int maxNum = 0;

            int nx, ny;

            for(int dir = 0; dir < 8; dir++) {
                nx = x + dx[dir];
                ny = y + dy[dir];

                if(inRange(nx, ny)) {
                    for(int num : grid[nx][ny]) {
                        if(num > maxNum) {
                            maxNum = num;
                            maxX = nx;
                            maxY = ny;
                        }
                    }
                }
            }

            if(maxX == -1 && maxY == -1) continue;

            int cor = 0;
            Deque<Integer> temp = new ArrayDeque<>();

            while(cor != number) {
                cor = grid[x][y].pop();
                temp.push(cor);
            }

            for(int num : temp) {
                grid[maxX][maxY].push(num);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j].isEmpty()) System.out.print("None");
                else {
                    for(int num : grid[i][j]) {
                        System.out.print(num + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}

// 각각의 칸은 스택으로 운영