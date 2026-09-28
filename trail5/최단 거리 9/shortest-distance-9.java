import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];

        int[] path = new int[n + 1];
        int[] dist = new int[n + 1];

        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            graph[x][y] = z;
            graph[y][x] = z;
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, (int)1e9);

        dist[a] = 0;

        for(int i = 1; i <= n; i++) {

            int minIndex = -1;
            for(int j = 1; j <= n; j++) {
                if(visited[j]) continue;

                if(minIndex == -1 || dist[minIndex] > dist[j]) minIndex = j;
            }

            visited[minIndex] = true;

            for(int j = 1; j <= n; j++) {
                if(graph[minIndex][j] == 0) continue;

                if(dist[j] > dist[minIndex] + graph[minIndex][j]) {
                    dist[j] = dist[minIndex] + graph[minIndex][j];

                    path[j] = minIndex;
                }
            }
        }

        System.out.println(dist[b]);

        int x = b;
        ArrayList<Integer> vertices = new ArrayList<>();
        vertices.add(x);
        while(x != a) {
            x = path[x];
            vertices.add(x);
        }

        for(int i = vertices.size() - 1; i >= 0; i--) {
            System.out.print(vertices.get(i) + " ");
        }

    }
}