import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, k;
    public static int[][] grid;

    public static void explode(int col) {
        boolean didExplosion;

        do {
            didExplosion = false;
            int curIdx = n - 1;

            while (curIdx >= 0) {
                if (grid[curIdx][col] == 0) {
                    curIdx--;
                    continue;
                }

                int endIdx = findEndIdx(curIdx, grid[curIdx][col], col);

                if (curIdx - endIdx + 1 >= m) {
                    for (int i = endIdx; i <= curIdx; i++) {
                        grid[i][col] = 0;
                    }
                    didExplosion = true;
                }
                
                curIdx = endIdx - 1;
            }

            if (didExplosion) {
                fall(col);
            }
        } while(didExplosion);
    }

    public static int findEndIdx(int startIdx, int num, int col) {
        int endIdx = startIdx - 1;

        while(endIdx >= 0) {
            if(grid[endIdx][col] == num) endIdx--;
            else break;
        }
        return endIdx + 1; // 0-based index
    }

    public static void rotate() {
        int[][] newArray = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                newArray[j][n - 1 - i] = grid[i][j];
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = newArray[i][j];
            }
        }
    }

    public static void fall(int col) {
        int[] newArray = new int[n];
        int idx = n - 1;

        for(int i = n - 1; i >= 0; i--) {
            if(grid[i][col] != 0) {
                newArray[idx--] = grid[i][col];
            }
        }

        for(int i = 0; i < n; i++) {
            grid[i][col] = newArray[i];
        }
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        


        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < k; i++) {
            for(int j = 0; j < n; j++) {
                explode(j);
            }

            rotate();

            for(int j = 0; j < n; j++) {
                fall(j);
            }
        }

        for(int j = 0; j < n; j++) {
                explode(j);
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int num : grid[i]) {
                if(num > 0) ans++;
            }
        }
        System.out.print(ans);
    }
}