import java.util.*;
import java.io.*;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static int n;
    public static int[][] grid;
    public static boolean[][] visited;

    public static boolean inRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= n;
    }
    
    public static boolean isPossible(int d) {
        int threshold = (n * n + 1) /2;
        visited = new boolean[n + 1][n + 1];
        Queue<Pair> q = new ArrayDeque<>();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                
                if(visited[i][j]) continue;

                q.add(new Pair(i, j));
                visited[i][j] = true;
                int count = 1;
                

                while(!q.isEmpty()) {
                    Pair cur = q.poll();

                    for(int m = 0; m < 4; m++) {
                        int nx = cur.x + dx[m];
                        int ny = cur.y + dy[m];

                        if(!inRange(nx, ny)) continue;

                        if(!visited[nx][ny] && Math.abs(grid[cur.x][cur.y] - grid[nx][ny]) <= d) {
                            q.add(new Pair(nx, ny));
                            visited[nx][ny] = true;
                            count++;
                        }
                    }
                }
                // System.out.printf("Mid = %d, count = %d\n", d, count);

                if(count >= threshold) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        grid = new int[n + 1][n + 1];

        StringTokenizer st;
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                grid[i][j] = num;
            }
        }


        int answer = Integer.MAX_VALUE;
        int left = 0;
        int right = 1000000;
        while(left <= right) {
            int mid = (left + right) / 2;

            if(isPossible(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.print(answer);
    }
}


// 1 2 3 4 5 6 7 8

// 1 2 3 0 1 1 1
// 1 3 6 6 7 8 9