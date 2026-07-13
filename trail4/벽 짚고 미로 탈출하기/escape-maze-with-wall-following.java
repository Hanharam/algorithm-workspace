import java.io.*;
import java.util.*;

public class Main {
    public static int n, x, y;
    public static char[][] grid;

    public static boolean isDone(int x, int y) {
        return (x < 0 || x >= n || y < 0 || y >= n);
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new char[n][n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken()) - 1;
        y = Integer.parseInt(st.nextToken()) -1;

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                grid[i][j] = str.charAt(j);
            }
        }

        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};

        int r = x;
        int c = y;
        int d = 0;

        int cnt = 0;
        int dir = 0;
        int turn = 0;

        do {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(isDone(nx, ny)) {
                cnt++;
                break; // 앞으로 전진하면 끝날 때
            }
            else if(grid[nx][ny] == '#') { // 진행 방향 바로 앞에 벽이 있을 경우
                dir = (dir + 1) % 4; // 방향 전환
                turn++;
            }
            else if(grid[nx + dx[(dir-1+4)%4]][ny + dy[(dir-1+4)%4]] == '#') { // 앞으로 전진 가능할 때
                x = nx;
                y = ny;
                cnt++;
                turn = 0;
            }
            else { 
                x = nx;
                y = ny;
                cnt++;
                dir = (dir - 1 + 4) % 4;
                turn = 0;
            }

            if((x == r && y == c) && ((cnt > 0 && d == dir) || turn > 3)) {
                cnt = -1;
                break;
            }
        } while(true);

        System.out.print(cnt);
    }
}

