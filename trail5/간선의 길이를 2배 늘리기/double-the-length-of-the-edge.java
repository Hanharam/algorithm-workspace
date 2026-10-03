import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[][] graph = new int[251][251];
    public static long[] dist;
    public static int[] path = new int[251];

    public static void dijkstra() {
        dist = new long[n + 1];
        boolean[] visited = new boolean[n + 1];

        Arrays.fill(dist, (int) 1e9);
        dist[1] = 0;

        for(int i = 0; i < n; i++) {
            int minIndex = -1;
            
            for(int j = 1; j <= n; j++) {
                if(visited[j]) continue;

                if(minIndex == -1 || dist[j] < dist[minIndex])
                    minIndex = j;
            }
            
            for(int j = 1; j <= n; j++) {
                if(graph[minIndex][j] == (int) 1e9) continue;

                if(dist[j] > dist[minIndex] + graph[minIndex][j]) {
                    dist[j] = dist[minIndex] + graph[minIndex][j];
                    path[j] = minIndex;
                }
            }
            visited[minIndex] = true;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], (int) 1e9);
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            graph[x][y] = z;
            graph[y][x] = z;
        }
        
        dijkstra();

        long originDist = dist[n];

        long newMaxDist = 0;

        int curNode = n;
        while(curNode != 1) {
            int target = curNode;
            curNode = path[curNode];

            graph[curNode][target] = 2 * graph[curNode][target];

            dijkstra();

            newMaxDist = Math.max(newMaxDist, dist[n]);

            graph[curNode][target] = graph[curNode][target] / 2;
        }
        System.out.print(newMaxDist - originDist);
    }
}