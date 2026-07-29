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
    public static int[][] grid = new int [100][100];
    public static boolean[][] visited = new boolean[100][100];
    public static int[][] step = new int[100][100];

    public static ArrayList<Pair> spoils = new ArrayList<>();
    public static Queue<Pair> q = new LinkedList<>();

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static void bfs() {
        for(int i = 0; i < spoils.size(); i++) {
            q.add(spoils.get(i));
        }

        while(!q.isEmpty()) {
            Pair p = q.poll();

            int x = p.x;
            int y = p.y;

            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(inRange(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;

                    if(grid[nx][ny] == 1) {
                        q.add(new Pair(nx, ny));
                        step[nx][ny] = step[x][y] + 1;
                    }
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

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] == 0) step[i][j] = -1;
                else if(grid[i][j] == 1) step[i][j] = -2;
                else {
                    step[i][j] = 0;
                    spoils.add(new Pair(i, j));
                }
            }
        }

        bfs();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(step[i][j] + " ");
            }
            System.out.println();
        }


    }
}