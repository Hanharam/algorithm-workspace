import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static int[] a;
    public static boolean[] visited;
    public static ArrayList<Integer>[] edges;
    public static long[][][] dp;

    public static final long NEG = Long.MIN_VALUE / 4;

    public static void dfs(int cur) {
        if(visited[cur]) return;

        for(int i = 0; i < 2; i++) {
            Arrays.fill(dp[cur][i], NEG);
        }

        dp[cur][1][1] = a[cur];
        dp[cur][0][0] = 0;

        visited[cur] = true;

        for(int next : edges[cur]) {
            if(visited[next]) continue;

            dfs(next);

            long[][] merged = new long[2][k + 1];
            Arrays.fill(merged[0], NEG);
            Arrays.fill(merged[1], NEG);

            for(int used = 0; used <= k; used++) {
                for(int take = 0; used + take <= k; take++) {
                    
                    // cur을 선택하지 않는 경우
                    if(dp[cur][0][used] != NEG) {
                        long childBest = Math.max(dp[next][1][take], dp[next][0][take]);

                        if(childBest != NEG) {
                            merged[0][take + used] = Math.max(merged[0][take + used], 
                            dp[cur][0][used] + childBest);
                        }
                    }

                    // cur을 선택할 경우
                    if(dp[cur][1][used] != NEG && dp[next][0][take] != NEG) {
                        merged[1][used + take] = Math.max(merged[1][used + take],
                        dp[cur][1][used] + dp[next][0][take]);
                    }
                }
            }
            dp[cur] = merged;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        a = new int[n + 1];
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

        for(int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        k = Integer.parseInt(br.readLine());

        dp = new long[n + 1][2][k + 1];  // 자신 번호||자신 포함 여부||총 포함 개수

        dfs(1);

        long max = Math.max(dp[1][0][k], dp[1][1][k]);
        System.out.print(max);
    }
}