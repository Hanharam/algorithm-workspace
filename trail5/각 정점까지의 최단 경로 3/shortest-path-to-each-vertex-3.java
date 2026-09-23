import java.util.*;
import java.io.*;

class Edge {
    int e, v;

    public Edge(int e, int v) {
        this.e = e;
        this.v = v;
    }
}

class Node implements Comparable<Node>{
    int idx, dist;

    public Node(int idx, int dist) {
        this.idx = idx;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node n) {
        if(dist != n.dist) return dist - n.dist;
        return idx - n.idx;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];

        int[] dist = new int[n + 1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            graph[x][y] = z;
        }

        for(int i = 1; i <= n; i++) {
            dist[i] = (int)1e9;
        }

        dist[1] = 0;

        for(int i = 1; i <= n; i++) {
            int minIdx = -1;
            for(int j = 1; j <= n; j++) {
                if(visited[j]) continue;

                if(minIdx == -1 || dist[minIdx] > dist[j]) minIdx = j;
            }

            visited[minIdx] = true;

            for(int j = 1; j <= n; j++) {
                if(graph[minIdx][j] == 0) continue;

                dist[j] = Math.min(dist[j], dist[minIdx] + graph[minIdx][j]);
            }
        }

        for(int i = 2; i <= n; i++) {
            if(dist[i] == 1e9) System.out.println(-1);
            else System.out.println(dist[i]);
        }
    }
}