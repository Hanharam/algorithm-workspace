import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] value;
    public static ArrayList<Integer>[] edges;
    public static long ans = 0;

    public static long dfs(int cur, int parent) {
        long balance = value[cur] - 1;

        for(int next : edges[cur]) {
            if(parent == next) continue;

            long childBalance = dfs(next, cur);

            ans += Math.abs(childBalance);

            balance += childBalance;
        }

        return balance;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

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

        System.out.print(ans);
    }
}

// 연산의 최소횟수