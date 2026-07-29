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
    public static int n;
    public static int r1, c1, r2, c2;

    public static int[][] step = new int[100][100];
    public static boolean[][] visited = new boolean[100][100];
    public static Queue<Pair> q = new LinkedList<>();

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static boolean canGo(int x, int y) {
        if(!inRange(x, y)) return false;
        if(visited[x][y]) return false;
        return true;
    }

    public static void push(int x, int y, int s) {
        visited[x][y] = true;
        q.add(new Pair(x, y));
        step[x][y] = s;
    }

    public static void bfs() {
        int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

        while(!q.isEmpty()) {
            Pair p = q.poll();

            for(int i = 0; i < 8; i++) {
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
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken()) - 1;
        c1 = Integer.parseInt(st.nextToken()) - 1;
        r2 = Integer.parseInt(st.nextToken()) - 1;
        c2 = Integer.parseInt(st.nextToken()) - 1;

        visited[r1][c1] = true;
        q.add(new Pair(r1, c1));
        step[r1][c1] = 0;

        bfs();

        if(visited[r2][c2]) System.out.print(step[r2][c2]);
        else System.out.print(-1);
    }
}