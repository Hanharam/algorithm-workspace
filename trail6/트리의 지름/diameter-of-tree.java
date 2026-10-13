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
    public static int n;
    public static ArrayList<Node>[] tree;
    public static boolean[] visited;
    public static int dPoint, dDist;

    public static void dfs(int k, int dist) {
        if(visited[k]) return;
        visited[k] = true;

        if(dDist < dist) {
            dPoint = k;
            dDist = dist;
        }

        for(Node n : tree[k]) {
            dfs(n.index, dist + n.dist);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        tree = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            tree[x].add(new Node(y, z));
            tree[y].add(new Node(x, z));
        }

        dfs(1, 0);

        visited = new boolean[n + 1];
        dDist = 0;

        dfs(dPoint, 0);
        
        System.out.print(dDist);
    }
}