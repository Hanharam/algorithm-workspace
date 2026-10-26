import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static ArrayList<Integer>[] tree;
    public static int[] dp;
    public static int[] val;
    
    public static void dfs(int k) {
        int sum = 0;
        
        for(int next : tree[k]) {
            dfs(next);

            if(dp[next] > 0) sum += dp[next];
        }

        dp[k] = sum + val[k];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        val = new int[n + 1];
        dp = new int[n + 1]; 
        tree = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 2; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            if(t == 0) a = -a;

            val[i] = a;
            tree[p].add(i);
        }

        dfs(1);

        System.out.print(dp[1]);
    }
}