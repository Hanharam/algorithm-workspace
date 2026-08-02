import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[] coin = new int[100];
    public static int[] dp = new int[10001];

    public static void initialize() {
        Arrays.fill(dp, Integer.MAX_VALUE);

        for(int i = 0; i < n; i++) {
            dp[coin[i]] = 1;
        }
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

        initialize();

        for(int i = 1; i <= m; i++) {
            for(int j = 0; j < n; j++) {
                if(i - coin[j] < 0 || dp[i - coin[j]] == Integer.MAX_VALUE) continue;

                dp[i] = Math.min(dp[i], dp[i - coin[j]] + 1);
            }
        }

        System.out.print(dp[m] == Integer.MAX_VALUE ? -1 : dp[m]);
    }
}