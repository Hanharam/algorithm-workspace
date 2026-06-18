import java.io.*;
import java.util.*;

public class Main {

    public static boolean inRange(int x, int y, int n) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] grid = new int[n][n];
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sum = 0;

        for(int x = 0; x < n; x++) {
            for(int y = 0; y < n; y++) {
                int cnt = 0;
                for(int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if(inRange(nx, ny, n) && grid[nx][ny] == 1) cnt++;
                }
                if(cnt >= 3) sum++;
            }
        }

        System.out.print(sum);

    }
}