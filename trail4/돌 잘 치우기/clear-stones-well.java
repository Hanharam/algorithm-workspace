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
    public static int m, k, n;
    public static int[][] grid;
    public static int answer = 0;
    
    public static ArrayList<Pair> stones = new ArrayList<>();
    public static ArrayList<Pair> starts = new ArrayList<>();

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static void BFS() {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visited = new boolean[n][n];
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < starts.size(); i++) {
            q.add(starts.get(i));
            visited[starts.get(i).x][starts.get(i).y] = true;
        }

        int count = starts.size();
        
        while(!q.isEmpty()) {
            Pair p = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(!inRange(nx, ny)) continue;
                if(visited[nx][ny] == true) continue;
                if(grid[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                q.add(new Pair(nx, ny));
                count++;
            }
        }

        answer = Math.max(count, answer);
    }

    public static void chooseStones(int start, int count) {
        if(count == m) {
            BFS();
            return;
        }

        for(int i = start; i < stones.size(); i++) {
            int r = stones.get(i).x;
            int c = stones.get(i).y;

            grid[r][c] = 0;
            chooseStones(i + 1, count + 1);
            grid[r][c] = 1;
        }

    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());

                if(grid[i][j] == 1) {
                    stones.add(new Pair(i, j));
                }
            }
        }

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            starts.add(new Pair(r, c));
        }

        chooseStones(0, 0);

        System.out.print(answer);
    }
}