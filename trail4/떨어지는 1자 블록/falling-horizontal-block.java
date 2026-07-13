import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, k;
    public static int[][] grid;

    public static int getBottom(int col) {
        for(int i = 1; i < n; i++) {
            if(grid[i][col] == 1){
                return i - 1;
            }
        }
        return n - 1;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()) - 1;

        grid = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    
        int top = n;
        for(int j = k; j <= k+m-1; j++) {
            int bottom = getBottom(j);
            top = Math.min(top, bottom);
        }

        for(int i = k; i <= k+m-1; i++) {
            grid[top][i] = 1;
        }

        for(int i = 0; i < n; i++) {
            for(int num : grid[i]) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }
}