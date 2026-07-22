import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, c;
    public static int answer = Integer.MIN_VALUE;
    
    public static int[][] grid;
    public static boolean[][] visited;

    public static int maxSquareSum;
    public static int[] selectedItems;
    

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static boolean canPlace(int x, int y) {
        for(int i = 0; i < m; i++) {
            if(!inRange(x, y + i) || visited[x][y + i]) return false;
        }
        return true;
    }

    public static void markVisited(int x, int y) {
        for(int i = 0; i < m; i++) {
            visited[x][y + i] = true;
        }
        return;
    }

    public static void unmarkVisited(int x, int y) {
        for(int i = 0; i < m; i++) {
            visited[x][y + i] = false;
        }
        return;
    }

    public static int getSum(int x, int y) {
        selectedItems = new int[m];

        for(int i = 0; i < m; i++) {
            selectedItems[i] = grid[x][y + i];
        }

        maxSquareSum = 0;
        findMaxSquareSum(0, 0, 0);

        return maxSquareSum;
    }

    public static void findMaxSquareSum(int idx, int currentSum, int currentSquareSum) {
        if(idx == m) {
            maxSquareSum = Math.max(maxSquareSum, currentSquareSum);
            return;
        }

        int item = selectedItems[idx];
        if(currentSum + item <= c) {
            findMaxSquareSum(idx + 1, currentSum + item, currentSquareSum + (item * item));
        }

        findMaxSquareSum(idx + 1, currentSum, currentSquareSum);
    }

    public static void findMax(int cnt, int currentSum) {
        if(cnt == 2) {
            answer = Math.max(answer, currentSum);
            return;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= n - m; j++) {

                if(canPlace(i, j)) {
                    markVisited(i, j);
                

                    findMax(cnt + 1, currentSum + getSum(i, j));

                    unmarkVisited(i, j);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findMax(0, 0);

        System.out.print(answer);

    }
}