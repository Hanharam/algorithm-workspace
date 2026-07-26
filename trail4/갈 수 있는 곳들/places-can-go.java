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
    public static int n, k;
    public static int[][] grid;
    public static boolean[][] visited;
    public static Queue<Pair> q = new LinkedList<>();

    public static int cnt = 0;


    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static boolean canGo(int x, int y) {
        if(!inRange(x, y)) return false;
        if(grid[x][y] == 1 || visited[x][y]) return false;
        return true;
    }

    public static void push(int x, int y) {
        cnt++;
        visited[x][y] = true;
        q.add(new Pair(x, y));
    }

    public static void BFS() {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        
        while(!q.isEmpty()) {
            Pair p = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

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
        k = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            if(canGo(x, y)) {
                push(x, y);
                BFS();
            }
        }

        System.out.print(cnt);
    }
}