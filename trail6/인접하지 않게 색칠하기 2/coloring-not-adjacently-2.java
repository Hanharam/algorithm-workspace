import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static ArrayList<Integer>[] edges;
    public static int[] a;
    public static long[][][] dp;

    public static final long NEG = Long.MIN_VALUE / 4;

    public static void dfs(int cur, int parent) {
        Arrays.fill(dp[cur][0], NEG);
        Arrays.fill(dp[cur][1], NEG);

        dp[cur][0][0] = 0;

        for(int i = 1; i <= k; i++) {
            dp[cur][1][i] = a[cur];
        }

        for(int next : edges[cur]) {
            if(next == parent) continue;

            dfs(next, cur);

            long[][] temp = new long[2][k + 1];

            for(int x = 0; x <= k; x++) {
                for(int y = 0; x + y <= k; y++) {
                    temp[0][x + y] = Math.max(
                        temp[0][x + y],
                        dp[cur][0][x] + Math.max(dp[next][0][y], dp[next][1][y])
                    );

                    temp[1][x + y] = Math.max(
                        temp[1][x + y],
                        dp[cur][1][x] + dp[next][0][y]
                    );
                }
            }

            dp[cur] = temp;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

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

        // 현재 노드 | 색칠 여부 | 색칠 노드 개수
        dp = new long[n + 1][2][k + 1];

        dfs(1, 0);
        
        long ans = 0;
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j <= k; j++) {
                ans = Math.max(ans, dp[1][i][j]);
            }
        }

        System.out.print(ans);
    }
}