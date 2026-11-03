import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_K = 10;
    public static final int MAX_N = 100000;

    public static int n, k;
    public static ArrayList<Integer>[] edges = new ArrayList[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static int[][][] dp = new int[MAX_N + 1][MAX_K + 1][2];
    public static int[] a = new int[MAX_N + 1];
    public static int ans;

    public static void dfs(int x) {
        dp[x][1][1] = a[x];
        dp[x][0][0] = 0;

        for(int l = 0; l < edges[x].size(); l++) {
            int y = edges[x].get(l);

            if(visited[y]) continue;

            visited[y] = true;
            dfs(y);

            // x 번 노드를 색칠하는 경우인 동시에 i 개의 노드가 색칠된 것을 기대
            // 지금까지 i -j 개의 노드를 칠했고 
            // 자식 노드 y에서 j개를 색칠하고 y는 색칠되면 안된다.
            for(int i = k; i >= 1; i--) {
                for(int j = 1; j <= i; j++) {
                    dp[x][i][1] = Math.max(dp[x][i][1], dp[x][i - j][1] + dp[y][j][0]);
                }
            }
            // x 번 노드를 색칠하지 않는 경우인 동시에 i 개의 노드가 색칠된 것을 기대
            // 지금까지 i - j개의 노드를 칠했고
            // 자식 노드 y에서 j개를 색칠하고 y의 색칠 여부는 상관 없다(가장 큰 값 구하기)
            for(int i = k; i >= 0; i--) {
                for(int j = 0; j <= i; j++) {
                    dp[x][i][0] = Math.max(dp[x][i][0], dp[x][i - j][0] + Math.max(dp[y][j][0], dp[y][j][1]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

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

        visited[1] = true;
        dfs(1);

        for(int i = 1; i <= k; i++) {
            ans = Math.max(ans, dp[1][i][0]);
            ans = Math.max(ans, dp[1][i][1]);
        }

        System.out.print(ans);
    }
}