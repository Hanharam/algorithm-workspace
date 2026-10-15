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
    public static int n, d;
    public static ArrayList<Edge>[] edges;
    public static boolean[] visited;
    public static int maxDist, maxEdge;
    public static int root;

    public static void dfs(int k, int dist, int edge) {
        if(visited[k]) return;
        visited[k] = true;

        if((maxEdge < edge) || (maxEdge == edge && maxDist > dist)) {
            maxEdge = edge;
            maxDist = dist;
            root = k;
        }

        for(Edge e : edges[k]) {
            dfs(e.index, dist + e.dist, edge + 1);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

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

        visited = new boolean[n + 1];
        maxDist = -1;
        maxEdge = -1;
        dfs(1, 0, 0);

        visited = new boolean[n + 1];
        maxDist = -1;
        maxEdge = -1;
        dfs(root, 0, 0);

        int ans = (maxDist + d - 1) / d;
        System.out.print(ans);
    }
}