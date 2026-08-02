import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[] coin = new int[100];
    public static int[] dp = new int[10001];

    public static void init() {
        for(int i = 1; i <= m; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        dp[0] = 0;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(st.nextToken());
        }

        init();

        for(int i = 1; i <= m; i++) {
            
            for(int j = 0; j < n; j++) {
                int num = coin[j];

                if(i - num < 0 || dp[i - num] == Integer.MIN_VALUE) continue;
                dp[i] = Math.max(dp[i], dp[i - num] + 1);
            }
        }

        System.out.print(dp[m] == Integer.MIN_VALUE ? -1 : dp[m]);
    }
}