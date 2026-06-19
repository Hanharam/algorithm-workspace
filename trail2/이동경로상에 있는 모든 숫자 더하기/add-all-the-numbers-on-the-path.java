import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static int toDir(char dir) {
        if(dir == 'E') return 0;
        else if(dir == 'S') return 1;
        else if(dir == 'W') return 2;
        else return 3;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dx = new int[]{0, 1, 0, -1}; // E, S, W, N
        int[] dy = new int[]{1, 0, -1, 0};

        n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n][n];
        char[] command = br.readLine().toCharArray();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = n/2;
        int y = n/2;
        int dir = 3;

        int sum = grid[x][y];

        for(int i = 0; i < t; i++) {

            if(command[i] == 'R') dir = (dir + 1) % 4;
            else if(command[i] == 'L') dir = (dir -1 + 4) % 4;
            else {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(inRange(nx, ny)){
                    x = nx;
                    y = ny;
                    sum += grid[x][y];
                }
            }
        }
        System.out.print(sum);
    }
}