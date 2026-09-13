import java.util.*;
import java.io.*;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static int m, n;
    public static int[][] grid;

    public static ArrayList<Pair> painted = new ArrayList<>();

    public static boolean[][] visited;

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < m && 0 <= y && y < n;
    }

    public static void dfs(int x, int y, int d) {
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(inRange(nx, ny) && !visited[nx][ny] && Math.abs(grid[x][y] - grid[nx][ny]) <= d) {
                visited[nx][ny] = true;
                dfs(nx, ny, d);
            }
        }
    }

    public static boolean isPossible(int d) {
        if(painted.isEmpty()) return true;

        visited = new boolean[m][n];

        Pair start = painted.get(0);
        visited[start.x][start.y] = true;

        dfs(start.x, start.y, d);

        for(Pair p : painted) {
            if(!visited[p.x][p.y]) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        grid = new int[m][n];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) painted.add(new Pair(i, j));
            }
        }

        int answer = Integer.MAX_VALUE;
        int left = 0;
        int right = 1000000000;
        while(left <= right) {
            int mid = (left + right) / 2;

            if(isPossible(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.print(answer);
    }
}