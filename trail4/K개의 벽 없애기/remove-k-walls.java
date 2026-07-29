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
    public static int n, k, r1, c1, r2, c2;
    public static int answer = -1;
    public static int[][] grid = new int[100][100];

    public static Queue<Pair> q;
    public static int[][] step;
    public static boolean[][] visited;

    public static ArrayList<Pair> walls = new ArrayList<>();


    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static boolean canGo(int x, int y) {
        return inRange(x, y) && grid[x][y] != 1 && !visited[x][y];
    }

    public static void refresh() {
        q = new LinkedList<>();
        step = new int[n][n];
        visited = new boolean[n][n];
    }

    public static void push(int x, int y, int s) {
        q.add(new Pair(x, y));
        visited[x][y] = true;
        step[x][y] = s;
    }  

    public static void findMax() {
        answer = Math.max(step[r2][c2], answer);
    }

    public static void bfs() {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            Pair p = q.poll();

            if(p.x == r2 && p.y == c2) {
                findMax();
                return;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(canGo(nx, ny)) {
                    push(nx, ny, step[p.x][p.y] + 1);
                }
            }
        }
    }

    public static void choose(int r, int curNum) {
        if(curNum == k + 1) {
            refresh();
            push(r1, c1, 0);
            bfs();
            return;
        }

        for(int i = r; i < walls.size(); i++) {
            grid[walls.get(i).x][walls.get(i).y] = 0;
            choose(i + 1, curNum + 1);
            grid[walls.get(i).x][walls.get(i).y] = 1;
        }
        
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] == 1) walls.add(new Pair(i, j));
            }
        }

        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken()) - 1;
        c1 = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        r2 = Integer.parseInt(st.nextToken()) - 1;
        c2 = Integer.parseInt(st.nextToken()) - 1;

        choose(0, 1);

        System.out.print(answer);
    }
}