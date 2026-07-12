import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] grid;

    public static int getRow(int col) {
        int row = 0;
        while(row < n) {
            if(grid[row][col] != 0) {
                break;
            }
            row++;
        }
        return row;
    }

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void explode(int row, int col) {
        int area = grid[row][col];

        for(int i = 0; i < area; i++) {
            if(inRange(row+i, col)) grid[row + i][col] = 0;
            if(inRange(row, col+i)) grid[row][col + i] = 0;
            if(inRange(row-i, col)) grid[row - i][col] = 0;
            if(inRange(row, col-i)) grid[row][col - i] = 0;
        }

        for(int i = 0; i < n; i++) {
            int[] temp = new int[n];
            int idx = n - 1;

            for(int j = n - 1; j >= 0; j--) {
                if(grid[j][i] != 0) temp[idx--] = grid[j][i];
            }

            for(int j = 0; j < n; j++) {
                grid[j][i] = temp[j];
            }
        }
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < m; i++) {
            int col = Integer.parseInt(br.readLine()) - 1;
            int row = getRow(col);

            if(row < n) explode(row, col);
        }

        for(int i = 0; i < n; i++) {
            for(int num : grid[i]) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}