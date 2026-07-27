import java.io.*;
import java.util.*;


class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int MAX_NUM = 8;

    public static int n, k, u, d;
    public static int[][] grid = new int[MAX_NUM][MAX_NUM];

    public static int answer = 0;

    public static Queue<Pair> q = new LinkedList<>();
    public static ArrayList<Pair> starts = new ArrayList<>();

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static boolean canGo(int x, int y, int nx, int ny) {
        if(!inRange(nx, ny)) return false;
        
        int diff = Math.abs(grid[x][y] - grid[nx][ny]);

        return u <= diff && diff <= d;
    }

    public static void bfs() {
        boolean[][] visited = new boolean[n][n];
        Queue<Pair> q = new LinkedList<>();
        int count = 0;

        for(Pair start : starts) {
            q.add(start);
            visited[start.x][start.y] = true;
            count++;
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            Pair p = q.poll();

            int x = p.x;
            int y = p.y;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(canGo(x, y, nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                    count++;
                }
            }
        }
        answer = Math.max(answer, count);
    }

    public static void chooseCity(int idx, int count) {
        if(count == k) {
            bfs();
            return;
        }

        for(int i = idx; i < n * n; i++) {
            int x = i / n;
            int y = i % n;

            starts.add(new Pair(x, y));
            chooseCity(i + 1, count + 1);
            starts.remove(starts.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        chooseCity(0, 0);
        System.out.print(answer);
    }
}