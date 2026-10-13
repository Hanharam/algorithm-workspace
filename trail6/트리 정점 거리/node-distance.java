import java.util.*;
import java.io.*;

class Node {
    int index, dist;

    public Node(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }
}

public class Main {
    public static int n, m;
    public static ArrayList<Node>[] edges;
    public static boolean[] visited;
    public static int gap;

    public static void dfs(int k, int dest, int dist) {
        if(visited[k]) return;

        if(k == dest) {
            gap = dist;
            return;
        }

        visited[k] = true;

        for(Node n : edges[k]) {
            dfs(n.index, dest, dist + n.dist);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        edges = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            edges[x].add(new Node(y, z));
            edges[y].add(new Node(x, z));
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == b) sb.append("0\n");
            else {
                visited = new boolean[n + 1];
                dfs(a, b, 0);
                sb.append(gap + "\n");
            }
        }

        System.out.print(sb);
    }
}