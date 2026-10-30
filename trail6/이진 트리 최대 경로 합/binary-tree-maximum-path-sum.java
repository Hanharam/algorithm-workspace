import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static ArrayList<Integer>[] edges;
    public static int[] value;
    public static long[] dp;
    public static long ans = Long.MIN_VALUE;

    public static void dfs(int cur, int parent) {
        long first = 0;
        long second = 0;

        for(int next : edges[cur]) {
            if(parent == next) continue;

            dfs(next, cur);

            long child = Math.max(0L, dp[next]);

            if(child >= first) {
                second = first;
                first = child;
            } else if(child > second) {
                second = child;
            }
        }

        dp[cur] = value[cur] + first;

        ans = Math.max(ans, value[cur] + first + second);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new long[n + 1];
        value = new int[n + 1];
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
            value[i] = Integer.parseInt(br.readLine());
        }

        dfs(1, 0);

        System.out.print(ans);
    }
}