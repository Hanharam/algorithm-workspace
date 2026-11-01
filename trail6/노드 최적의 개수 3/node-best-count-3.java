import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static ArrayList<Integer>[] edges;
    public static int[][] dp;

    public static final int INF = 1_000_000_000;

    public static void dfs(int cur, int parent) {
        dp[cur][0] = 1;
        dp[cur][1] = INF;
        dp[cur][2] = 0;

        int base = 0;
        int selectedChildCost = INF;
        boolean hasChild = false;

        for(int next : edges[cur]) {
            if(next == parent) continue;

            hasChild = true;
            dfs(next, cur);

            dp[cur][0] += Math.min(dp[next][0], Math.min(dp[next][1], dp[next][2]));


            int childMin = Math.min(dp[next][0], dp[next][1]);
            base += childMin;
            

            selectedChildCost = Math.min(selectedChildCost, dp[next][0] - childMin);
        }

        dp[cur][2] = base;

        if(hasChild) {
            dp[cur][1] = base + selectedChildCost;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1][3]; // 자신 번호, {자신 선택, 자식 선택 강제, 부모 선택 강제}

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

        dfs(1, 0);

        System.out.print(Math.min(dp[1][0], dp[1][1]));
    }
}