import java.util.*;
import java.io.*;

class Edge {
    int index, dist;

    public Edge(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }
}

public class Main {
    public static int n;
    public static ArrayList<Edge>[] edges;
    public static boolean[] visited;
    public static int root;
    public static int maxDist;

    public static void dfs(int k, int dist) {
        if(visited[k]) return;
        visited[k] = true;

        if(maxDist < dist) {
            maxDist = dist;
            root = k;
        }

        for(Edge e : edges[k]) {
            dfs(e.index, dist + e.dist);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        edges = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            edges[x].add(new Edge(y, z));
            edges[y].add(new Edge(x, z));
        }

        maxDist = -1;
        visited = new boolean[n + 1];
        dfs(1, 0);

        maxDist = -1;
        visited = new boolean[n + 1];
        dfs(root, 0);
        
        System.out.print(maxDist);
    }
}