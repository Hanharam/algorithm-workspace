import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_NUM = 50;
    public static final int DIR_NUM = 4;

    public static int n, m;
    public static int height;

    public static int[][] grid = new int[MAX_NUM][MAX_NUM];
    public static boolean[][] visited;

    public static int[] result = new int[101];

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    public static boolean canGo(int x, int y) {
        if(!inRange(x, y)) return false;
        if(grid[x][y] <= height || visited[x][y]) return false;
        return true;
    }

    public static void DFS(int x, int y) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int i = 0; i < DIR_NUM; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(canGo(nx, ny)) {
                visited[nx][ny] = true;
                DFS(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int limit = Integer.MIN_VALUE;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int curNum = Integer.parseInt(st.nextToken());
                limit = Math.max(curNum, limit);
                grid[i][j] = curNum;
            }
        }

        for(int i = 1; i <= limit; i++) {
            height = i;
            visited = new boolean[n][m];
            int area = 0;
            for(int l = 0; l < n; l++) {
                for(int k = 0; k < m; k++) {
                    if(canGo(l, k)) {
                        visited[l][k] = true;
                        area++;
                        DFS(l, k);
                    }
                }
            }
            result[height] = area;
        }

        int ans = -1;
        int k = 0;
        for(int i = 1; i <= limit; i++) {
            if(ans < result[i]) {
                ans = result[i];
                k = i;
            }
        }
        System.out.print(k + " " + ans);
    }
}