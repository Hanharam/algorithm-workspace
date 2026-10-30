import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] value;
    public static ArrayList<Integer>[] edges;
    public static int[][] dp;

    public static void dfs(int cur, int parent) {
        dp[cur][1] = value[cur];

        for(int next : edges[cur]) {
            if(parent == next) continue;

            dfs(next, cur);

            dp[cur][1] += dp[next][0];
            dp[cur][0] += Math.max(dp[next][1], dp[next][0]);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1][2];
        value = new int[n + 1];
        edges = new ArrayList[n + 1];

        for(int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            edges[x].add(y);
            edges[y].add(x);
        }

        dfs(1, 0);

        System.out.print(Math.max(dp[1][0], dp[1][1]));
    }
}

// 인접하면 안됨
// 선택하지 안흐면 하나의 선택한 정점과 인접해 있어야 함
// 