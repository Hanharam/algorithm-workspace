import java.util.*;
import java.io.*;

class Node {
    int idx;
    boolean selected;

    public Node(int idx, boolean selected) {
        this.idx = idx;
        this.selected = selected;
    }
}

public class Main {
    public static int n;
    public static int[] a;
    public static int[][] dp;
    public static ArrayList<Integer>[] edges;
    public static ArrayList<Integer> answer;

    public static void dfs(int cur, int parent) {
        dp[cur][1] = a[cur];

        for(int next : edges[cur]) {
            if(next == parent) continue;

            dfs(next, cur);

            dp[cur][0] += Math.max(dp[next][1], dp[next][0]);
            dp[cur][1] += dp[next][0];
        }
    }

    public static void reconstruct(int cur, int parent, boolean parentSelected) {
        boolean currentSelected;

        if(parentSelected) {
            currentSelected = false;
        } else {
            currentSelected = dp[cur][1] > dp[cur][0];
        }

        if(currentSelected) answer.add(cur);

        for(int next : edges[cur]) {
            if(next == parent) continue;

            reconstruct(next, cur, currentSelected);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        dp = new int[n + 1][2];
        a = new int[n + 1];
        edges = new ArrayList[n + 1];
        answer = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            edges[x].add(y);
            edges[y].add(x);
        }

        dfs(1, 0);
        reconstruct(1, 0, false);

        Collections.sort(answer);

        sb.append(Math.max(dp[1][1], dp[1][0])).append("\n");

        for(int num : answer) {
            sb.append(num + " ");
        }

        System.out.print(sb);
    }
}