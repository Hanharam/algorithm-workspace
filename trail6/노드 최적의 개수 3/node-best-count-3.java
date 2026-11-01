import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static ArrayList<Integer>[] edges;
    public static int[] parent;
    public static boolean[] visited;

    // dp[i][j][k]: i 번 노드의 서브트리까지 고려했을 때
    //              dp[i][1][0] i 번째 선택은 안했지만 보장 받고 있음
    //              dp[i][1][1] i 번째 선택하고 보장 받고 있음
    //              dp[i][0][1] i 번째 선택하고 보장 못 받음 (불가능)
    //              dp[i][0][0] i 번째 선택 안하고 보방도 못 받음
    public static long[][][] dp;

    public static void dfs(int cur) {
        for(int next : edges[cur]) {
            if(visited[next]) continue;
            visited[next] = true;
            parent[next] = cur;
            dfs(next);
        }

        dp[cur][0][0] = 0;
        dp[cur][1][0] = 0;
        dp[cur][1][1] = 1;

        for(int i = 0; i < edges[cur].size(); i++) {
            int next = edges[cur].get(i);

            if(parent[next] != cur) continue;

            // case 1) (next, 0, 0)
            dp[cur][0][0] += dp[next][1][0];

            // case 2) (next, 1, 0)
            dp[cur][1][0] += Math.min(dp[next][1][0], dp[next][1][1]);

            // case 3) (next 1, 1)
            dp[cur][1][1] += Math.min(dp[next][0][0], Math.min(dp[next][1][0], dp[next][1][1]));
        }

        if(dp[cur][1][0] == 0) dp[cur][1][0] = (int)1e9;
        else {
            long best = (int)1e9;
            for(int i = 0; i < edges[cur].size(); i++) {
                int next = edges[cur].get(i);

                if(parent[next] != cur) continue;

                best = Math.min(best, dp[cur][1][0] - Math.min(dp[next][1][1], dp[next][1][0]) + dp[next][1][1]);
            }

            dp[cur][1][0] = best;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new long[n + 1][2][2]; //
        parent = new int[n + 1];
        visited = new boolean[n + 1];

        edges = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            edges[x].add(y);
            edges[y].add(x);
        }

        visited[1] = true;
        dfs(1);

        System.out.print(Math.min(dp[1][1][0], dp[1][1][1]));
    }
}