import java.util.*;
import java.io.*;

class Edge {
    int y, d;

    public Edge(int y, int d) {
        this.y = y;
        this.d = d;
    }
}

public class Main {
    public static int n;
    public static ArrayList<Edge>[] edges;

    public static void dfs(int k, int dist, int[] distArray) {
        distArray[k] = dist;
        
        for(Edge e : edges[k]) {
            if(distArray[e.y] == -1) {
                dfs(e.y, dist + e.d, distArray);
            }
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

        int[] distFrom1 = new int[n + 1];
        Arrays.fill(distFrom1, -1);
        dfs(1, 0, distFrom1);

        int U = 1;
        for(int i = 1; i <= n; i++) {
            if(distFrom1[i] > distFrom1[U]) U = i;
        }


        int[] distU = new int[n + 1];
        Arrays.fill(distU, -1);
        dfs(U, 0, distU);

        int V = 1;
        for(int i = 1; i <= n; i++) {
            if(distU[i] > distU[V]) V = i;
        }

        int[] distV = new int[n + 1];
        Arrays.fill(distV, -1);
        dfs(V, 0, distV);

        ArrayList<Integer> paths = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(i != U) paths.add(distU[i]);
            if(i != V && i != U) paths.add(distV[i]);
        }
        
        paths.sort(Collections.reverseOrder());
        System.out.print(paths.get(1));
    }
}