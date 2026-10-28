import java.util.*;
import java.io.*;

public class Main {
    public static int n, s, d, lastIdx;
    public static ArrayList<Integer>[] edges;
    public static boolean[] visited;
    public static int[] dp;
    public static int answer = 0;

    public static void setArray(int cur) {
        visited[cur] = true;
        dp[cur] = 1;

        int max = 0;

        for(int next : edges[cur]) {
            if(visited[next]) continue;

            setArray(next);
            max = Math.max(max, dp[next]);
        }

        dp[cur] += max;
    }

    public static void calculateDist(int cur) {
        visited[cur] = true;

        for(int next : edges[cur]) {
            if(visited[next] || dp[next] <= d) continue;
            answer++;
            calculateDist(next);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

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

        visited = new boolean[n + 1];  
        dp = new int[n + 1];
        setArray(s);

        visited = new boolean[n + 1];
        calculateDist(s);

        System.out.print(answer * 2);
    }
}