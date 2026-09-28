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

        dist[b] = 0;
        
        for(int i = 1; i <= n; i++) {

            int minIndex = -1;
            for(int j = 1; j <= n; j++) {
                if(visited[j]) continue;

                if(minIndex == -1 || dist[minIndex] > dist[j]) 
                    minIndex = j;
            }

            for(int j = 1; j <= n; j++) {
                if(graph[minIndex][j] == 0) continue;

                if(dist[j] > dist[minIndex] + graph[minIndex][j])
                    dist[j] = dist[minIndex] + graph[minIndex][j];
            }

            visited[minIndex] = true;
        }

        System.out.println(dist[a]);
        ArrayList<Integer> ans = new ArrayList<>();
        int x = a;
        System.out.print(x + " ");
        while(x != b) {
            for(int i = 1; i <= n; i++) {
                if(graph[i][x] == 0) continue;

                if(dist[x] == dist[i] + graph[i][x]) {
                    x = i;
                    break;
                }
            }
            System.out.print(x + " ");
        }
    }
}