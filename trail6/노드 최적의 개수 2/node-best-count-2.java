import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static ArrayList<Integer>[] edges;
    public static boolean[] visited, placed;
    public static int[][] dp;

    public static void dfs(int x) {
        visited[x] = true;

        dp[x][1] = 1;
        if(placed[x]) dp[x][0] = Integer.MAX_VALUE / 4;
        else dp[x][0] = 0;

        for(int y : edges[x]) {
            if(visited[y]) continue;

            dfs(y);

            dp[x][1] += Math.min(dp[y][0], dp[y][1]);
            dp[x][0] += dp[y][1];
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        placed = new boolean[n + 1];
        dp = new int[n + 1][2];

        edges = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            edges[x].add(y);
            edges[y].add(x);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            placed[num] = true;
        }

        dfs(1);

        System.out.print(Math.min(dp[1][1], dp[1][0]) - m);
    }
}