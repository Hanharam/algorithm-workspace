import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y >=0 && y < m);
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] answer = new int[n][m];

        answer[0][0] = 1;
        int x = 0;
        int y = 0;

        int dir = 0;

        for(int i = 2; i <= n*m; i++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(inRange(nx, ny) && answer[nx][ny] == 0) {
                x = nx;
                y = ny;
                answer[x][y] = i;
            }
            else {
                dir = (dir + 1) % 4;
                x += dx[dir];
                y += dy[dir];
                answer[x][y] = i;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}