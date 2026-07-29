import java.io.*;
import java.util.*;

class Pair{
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n, h, m;
    public static int[][] grid = new int[100][100];

    public static int[][] step = new int[100][100];
    public static boolean[][] visited = new boolean[100][100];
    public static Queue<Pair> q = new LinkedList<>();
    public static ArrayList<Pair> sPos = new ArrayList<>();


    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static boolean canGo(int x, int y) {
        if(!inRange(x, y)) return false;
        if(visited[x][y] || grid[x][y] == 1) return false;
        return true;
    }

    public static void push(int x, int y, int s) {
        q.add(new Pair(x, y));
        visited[x][y] = true;
        step[x][y] = s;
    }

    public static int bfs() {
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

        return -1;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] == 3) {
                    sPos.add(new Pair(i, j));
                }
            }
        }

        for(int i = 0; i < sPos.size(); i++) {
            push(sPos.get(i).x, sPos.get(i).y, 0);
        }

        bfs();


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 2)
                    System.out.print(0 + " ");
                else {
                    if(!visited[i][j])
                        System.out.print(-1 + " ");
                    else
                        System.out.print(step[i][j] + " ");
                }
            }
            System.out.println();
        }

    }
}