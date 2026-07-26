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

    public static int currX, currY;

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
    
    public static boolean BFS() {
        boolean[][] visited = new boolean[n][n];
        Queue<Pair> q = new LinkedList<>();

        int curNum = grid[currX][currY];

        q.add(new Pair(currX, currY));
        visited[currX][currY] = true;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int bestX = -1, bestY = -1;
        int maxNum = 0;

        while(!q.isEmpty()) {
            Pair p = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(!inRange(nx, ny) || visited[nx][ny] || grid[nx][ny] >= curNum) {
                    continue;
                }

                q.add(new Pair(nx, ny));
                visited[nx][ny] = true;

                if(grid[nx][ny] > maxNum) {
                    maxNum = grid[nx][ny];
                    bestX = nx;
                    bestY = ny;
                } else if(grid[nx][ny] == maxNum) {
                    if(nx < bestX) {
                        bestX = nx;
                        bestY = ny;
                    } else if(nx == bestX && ny < bestY) {
                        bestY = ny;
                    }
                }
            }
        }

        if(bestX == -1 && bestY == -1) {
            return false;
        }

        currX = bestX;
        currY = bestY;

        return true;
    }


    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        grid = new int[n][n];    

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        currX = Integer.parseInt(st.nextToken()) - 1;
        currY = Integer.parseInt(st.nextToken()) - 1;


        while(k-- > 0) {
            boolean isMoved = BFS();
            if(!isMoved) break;
        }

        System.out.print((currX + 1) + " " + (currY + 1));
    }
}