import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] grid;

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    public static int meltOneSecond() {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        List<int[]> melted = new ArrayList<>();

        q.add(new int[]{0, 0});

        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(!inRange(nx, ny) || visited[nx][ny]) continue;

                visited[nx][ny] = true;

                if(grid[nx][ny] == 1) {
                    melted.add(new int[]{nx, ny});
                } else {
                    q.add(new int[]{nx, ny});
                }
            }
        }

        for(int[] ice : melted) {
            grid[ice[0]][ice[1]] = 0;
        }

        return melted.size();
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

        int time = 0;
        int lastCount = 0;

        while(true) {
            int melted = meltOneSecond();

            if(melted == 0) break;

            time++;
            lastCount = melted;
        }

        System.out.print(time + " " + lastCount);
    }
}