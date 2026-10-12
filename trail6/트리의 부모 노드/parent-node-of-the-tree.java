import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static ArrayList<Integer>[] tree;
    public static int[] parent;
    public static boolean[] visited;

    public static void dfs(int cur, int prt) {
        if(visited[cur]) return;

        visited[cur] = true;
        parent[cur] = prt;

        for(int child : tree[cur]) {
            dfs(child, cur);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
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

            tree[x].add(y);
            tree[y].add(x);
        }

        dfs(1, 1);

        for(int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }
}