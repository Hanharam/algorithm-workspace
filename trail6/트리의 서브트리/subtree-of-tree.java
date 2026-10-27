import java.util.*;
import java.io.*;

public class Main {
    public static int n, r, q;
    public static ArrayList<Integer>[] tree;
    public static boolean[] visited;
    public static int[] dp;

    public static void dfs(int k) {
        visited[k] = true;
        dp[k] = 1;

        for(int num : tree[k]) {
            if(visited[num]) continue;

            dfs(num);
            dp[k] += dp[num];
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        dp = new int[n + 1];
        visited = new boolean[n + 1];
        tree = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree[x].add(y);
            tree[y].add(x);
        }

        dfs(r);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++) {
            int u = Integer.parseInt(br.readLine());
            sb.append(dp[u]).append("\n");
        }

        System.out.print(sb);
    }
}