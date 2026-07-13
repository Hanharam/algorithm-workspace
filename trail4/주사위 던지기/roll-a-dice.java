import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, r, c;
    public static int[][] grid;

    // 윗면:0, 위쪽:1, 오른쪽:2, 왼쪽:3, 아래쪽:4, 아랫면:5
    public static int[] dice = {1, 5, 3, 4, 2, 6};

    public static int turnU() {
        int temp = dice[5];
        dice[5] = dice[1];
        dice[1] = dice[0];
        dice[0] = dice[4];
        dice[4] = temp;

        return dice[5];
    }

    public static int turnD() {
        int temp = dice[5];
        dice[5] = dice[4];
        dice[4] = dice[0];
        dice[0] = dice[1];
        dice[1] = temp;

        return dice[5];
    }

    public static int turnR() {
        int temp = dice[5];
        dice[5] = dice[2];
        dice[2] = dice[0];
        dice[0] = dice[3];
        dice[3] = temp;

        return dice[5];
    }

    public static int turnL() {
        int temp = dice[5];
        dice[5] = dice[3];
        dice[3] = dice[0];
        dice[0] = dice[2];
        dice[2] = temp;

        return dice[5];
    }

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
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

        st = new StringTokenizer(br.readLine());
        
        int[] dx = {1, 0, -1, 0}; // D, R, U, L
        int[] dy = {0, 1, 0, -1};
        int x = r;
        int y = c;

        grid[x][y] = dice[5];
        for(int i = 0; i < m; i++) {
            char dir = st.nextToken().charAt(0);
            int nx, ny;

            if(dir == 'D') {
                nx = x + dx[0];
                ny = y + dy[0];
            }
            else if(dir == 'R') {
                nx = x + dx[1];
                ny = y + dy[1];
            }
            else if(dir == 'U') {
                nx = x + dx[2];
                ny = y + dy[2];
            }
            else {
                nx = x + dx[3];
                ny = y + dy[3];
            }

            if(!inRange(nx, ny)) continue;

            if(dir == 'D') {
                turnD();
            }
            else if(dir == 'R') {
                turnR();
            }
            else if(dir == 'U') {
                turnU();
            }
            else if(dir == 'L') {
                turnL();
            }
            grid[nx][ny] = dice[5];
            x = nx;
            y = ny;
        
        }

        int sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sum += grid[i][j];
            }
        }

        System.out.print(sum);
    }
}
