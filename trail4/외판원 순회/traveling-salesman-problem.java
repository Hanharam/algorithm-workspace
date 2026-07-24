import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[][] grid;
    public static boolean[] visited;
    public static int ans = Integer.MAX_VALUE;

    public static void findMinCost(int curNum, int curIdx, int sumVal) {
        if(curNum == n) {
            if(grid[curIdx][1] == 0) return;
            sumVal += grid[curIdx][1];
            ans = Math.min(ans, sumVal);
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(visited[i] == true || grid[curIdx][i] == 0) continue;

            visited[i] = true;
            findMinCost(curNum + 1, i, sumVal + grid[curIdx][i]);
            visited[i] = false;
        }
        return;
    }



    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        grid = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i + 1][j + 1] = Integer.parseInt(st.nextToken());
            }
        }

        visited[1] = true;
        findMinCost(1, 1, 0);

        System.out.print(ans);
    }
}