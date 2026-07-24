import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[][] grid;
    public static boolean[][] visited;
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static int ans = Integer.MIN_VALUE;

    public static void calc() {
        int minVal = Integer.MAX_VALUE;

        for(int i = 0; i < arr.size(); i++) {
            minVal = Math.min(minVal, arr.get(i));
        }

        ans = Math.max(minVal, ans);
    }

    public static boolean canPaint(int y) {
        for(int i = 0; i < n; i++) {
            if(visited[i][y] == true) return false;
        }
        return true;
    }

    public static void findMinValue(int row) {
        if(row == n) {
            calc();
            return;
        }

        for(int i = 0; i < n; i++) {
            if(canPaint(i)) {
                visited[row][i] = true;
                arr.add(grid[row][i]);
                findMinValue(row + 1);
                visited[row][i] = false;
                arr.remove(arr.size() - 1);
            }
        }
        return;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        findMinValue(0);

        System.out.print(ans);
    }
}