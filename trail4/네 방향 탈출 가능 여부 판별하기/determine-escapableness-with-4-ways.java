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
    public static boolean[][] visited;
    public static boolean isTrue = false;

    public static Queue<Pair> q = new LinkedList<>();

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    public static boolean canGo(int x, int y) {
        if(!inRange(x, y)) return false;
        if(grid[x][y] == 0 || visited[x][y]) return false;
        return true;
    }

    public static void push(int x, int y) {
        visited[x][y] = true;
        q.add(new Pair(x, y));
    }

    public static void BFS( ) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!q.isEmpty()) {

            Pair p = q.poll();
 
            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx == n - 1 && ny == m - 1) {
                    isTrue = true;
                    return;
                }

                if(canGo(nx, ny)) {
                    push(nx, ny);
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
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        push(0, 0);
        BFS();
        if(isTrue) System.out.print(1);
        else System.out.print(0);
    }
}