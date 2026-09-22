import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[][] grid;

    public static void reverse(int x, int y) {
        for(int i = 0; i <= x; i++) {
            for(int j = 0; j <= y; j++) {
                grid[i][j] ^= 1;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                grid[i][j] = str.charAt(j) - '0';
            }
        }

        int answer = 0;
        for(int i = n - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(grid[i][j] == 1) {
                    reverse(i, j);
                    answer++;
                }
            }
        }
        System.out.print(answer);
    }
}