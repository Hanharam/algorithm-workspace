import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static ArrayList<Integer>[] tree;
    public static int[][] dp;
    public static boolean[] visited;

    public static void dfs(int k) {
        visited[k] = true;
        dp[k][1] = 1;

        for(int next : tree[k]) {
            if(visited[next]) continue;

            dfs(next);
            
            dp[k][1] += Math.min(dp[next][1], dp[next][0]);
            dp[k][0] += dp[next][1];
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1][2];
        visited = new boolean[n + 1];
        tree = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree[x].add(y);
            tree[y].add(x);
        }

        dfs(1);

        System.out.print(Math.min(dp[1][0], dp[1][1]));
    }
}