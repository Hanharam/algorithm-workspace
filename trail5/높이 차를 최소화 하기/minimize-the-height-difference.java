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

    public static int n, m;
    public static int[][] grid;

    public static boolean inRange(int x, int y) {
        return 1<= x && x <= n && 1 <= y && y <= m;
    }

    public static boolean bfs(int min , int max) {
        if(grid[1][1] < min || grid[1][1] > max) return false;

        boolean[][] visited = new boolean[n + 1][m + 1];
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(1, 1));
        visited[1][1] = true;
        while(!q.isEmpty()) {
            Pair p = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(p.x == n && p.y == m) return true;

                if(inRange(nx, ny) && !visited[nx][ny]) {
                    
                    if(grid[nx][ny] >= min && grid[nx][ny] <= max) {
                        visited[nx][ny] = true;
                        q.offer(new Pair(nx, ny));
                    }
                }
            }
        }
        return false;
    }

    public static boolean isPossible(int limit) {
        for(int min_val = 1; min_val <= 500; min_val++) {
            int max_val = min_val + limit;

            if(bfs(min_val, max_val)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        int left = 0;
        int right = 500;
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