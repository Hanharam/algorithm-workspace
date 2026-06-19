import java.io.*;
import java.util.*;

public class Main {
    public static boolean inRange(int x, int y, int n) {
        return ( x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dx = new int[]{1, 0, -1, 0}; // S, W, N, E
        int[] dy = new int[]{0, -1, 0, 1};

        int n = Integer.parseInt(br.readLine());

        char[][] grid = new char[n][n];

        for(int i = 0; i < n; i++) {
            char[] mirrors = br.readLine().toCharArray();
            for(int j = 0; j < n; j++) {
                grid[i][j] = mirrors[j];
            }
        }

        int num = Integer.parseInt(br.readLine());
        int moveDir;
        int x, y;

        // 초기 방향, 위치
        if(num <= n) {
            x = 0; y = num - 1; moveDir = 0;
        }
        else if(num <= 2 * n) {
            x = num - n - 1; y = n - 1; moveDir = 1;
        }
        else if(num <= 3 * n) {
            x = n - 1; y = 3 * n - num; moveDir = 2;
        }
        else {
            x = 4 * n - num; y = 0; moveDir = 3;
        }

        int moveNum = 0;

        while(inRange(x, y, n)) {
            if(grid[x][y] == '/') {
                moveDir = moveDir ^ 1;
                x += dx[moveDir];
                y += dy[moveDir];
            }
            else {
                moveDir = 3 - moveDir;
                x += dx[moveDir];
                y += dy[moveDir];
            }
            moveNum++;
        }

        System.out.print(moveNum);
    }
}