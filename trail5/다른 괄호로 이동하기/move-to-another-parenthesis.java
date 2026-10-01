import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair>{
    int x, y, cost;

    public Pair(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Pair p) {
        return cost - p.cost;
    }
}

public class Main {
    public static int n, a, b;
    public static char[][] grid;
    public static ArrayList<Pair>[][] graph;

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static int findMinDist(int x, int y) {
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int) 1e9);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        dist[x][y] = 0;
        pq.add(new Pair(x, y, 0));

        while(!pq.isEmpty()) {
            int curX = pq.peek().x;
            int curY = pq.peek().y;
            int curCost = pq.peek().cost;
            pq.poll();

            if(curCost != dist[curX][curY]) continue;

            for(int i = 0; i < graph[curX][curY].size(); i++) {
                int nx = graph[curX][curY].get(i).x;
                int ny = graph[curX][curY].get(i).y;
                int nCost = graph[curX][curY].get(i).cost;

                int newCost = curCost + nCost;
                if(newCost < dist[nx][ny]) {
                    dist[nx][ny] = newCost;
                    pq.add(new Pair(nx, ny, newCost));
                }
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == x && j == y) continue;
                max = Math.max(dist[i][j], max);
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        grid = new char[n][n];

        for(int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        graph = new ArrayList[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                graph[i][j] = new ArrayList<>();    
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                
                for(int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if(inRange(nx, ny)) {
                        if(grid[i][j] == grid[nx][ny]) {
                            graph[i][j].add(new Pair(nx, ny, a));
                        } else {
                            graph[i][j].add(new Pair(nx, ny, b));
                        }
                    }
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ans = Math.max(ans, findMinDist(i, j));
            }
        }

        System.out.print(ans);
    }
}