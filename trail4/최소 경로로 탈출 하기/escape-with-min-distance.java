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
    public static int n, m;
    public static int[][] grid;

    public static boolean[][] visited = new boolean[100][100];
    public static int[][] step = new int[100][100];

    public static Queue<Pair> q = new LinkedList<>();

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    public static boolean canGo(int x, int y) {
        if(!inRange(x, y)) return false;
        if(grid[x][y] == 0 || visited[x][y]) return false;

        return true;
    }

    public static void push(int x, int y, int s) {
        q.add(new Pair(x, y));
        step[x][y] = s;
        visited[x][y] = true;
    }

    public static void bfs() {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            Pair p = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(canGo(nx, ny)) {
                    push(nx, ny, step[p.x][p.y] + 1);
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

        grid = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        step[0][0] = 0;
        visited[0][0] = true;
        q.add(new Pair(0, 0));
        bfs();
        if(step[n-1][m-1] == 0) System.out.print(-1);
        else System.out.print(step[n - 1][m - 1]);
    }
}