import java.util.*;
import java.io.*;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 1000;

    public static int n, m;
    public static int[][] graph = new int[MAX_N + 1][MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];

    public static int[] dist = new int[MAX_N + 1];

    public static void dijkstra(int k) {
        for(int i = 1; i <= n; i++) {
            dist[i] = (int) 1e9;
        }

        for(int i = 1; i <= n; i++) {
            visited[i] = false;
        }

        dist[k] = 0;
        for(int i = 0; i < n; i++) {
            int minIndex = -1;

            for(int j = 1; j <= n; j++) {
                if(visited[j]) continue;

                if(minIndex == -1 || dist[minIndex] > dist[j]) 
                    minIndex = j;
            }

            visited[minIndex] = true;
            for(int j = 1; j <= n; j++) {
                if(graph[minIndex][j] == 0) continue;

                if(dist[j] > dist[minIndex] + graph[minIndex][j])
                    dist[j] = dist[minIndex] + graph[minIndex][j];
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            graph[x][y] = z;
            graph[y][x] = z;
        }

        dijkstra(n);

        int x = 1;
        ArrayList<Integer> vertices = new ArrayList<>();
        vertices.add(x);
        while(x != n) {
            for(int i = 1; i <= n; i++) {
                if(graph[i][x] == 0)
                    continue;
                
                if(dist[x] == graph[i][x] + dist[i]) {
                    x = i;
                    break;
                }
            }
            vertices.add(x);
        }

        for(int i = 0; i < vertices.size() - 1; i++) {
            int a = vertices.get(i);
            int b = vertices.get(i + 1);
            graph[a][b] = 0;
            graph[b][a] = 0;
        }

        dijkstra(1);

        int ans = dist[n];

        if(ans == (int) 1e9) ans  = -1;

        System.out.print(ans);
    }
}