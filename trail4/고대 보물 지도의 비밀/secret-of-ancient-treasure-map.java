import java.io.*;
import java.util.*;

public class Main {
    public static final int INF = 1000000009;

    public static int n, k;
    public static int[] map = new int[100001];
    public static int[][] dp = new int[100001][11];

    public static void init() {
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= k; j++) {
                dp[i][j] = -INF;
            }
        }

        dp[0][0] = 0;
        if(map[1] >= 0) dp[1][0] = map[1];
        else dp[1][1] = map[1];
    }


    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        
        
        init();

        int ans = map[1];
        for(int i = 2; i <= n; i++) {

            if(map[i] >= 0) {
                dp[i][0] = Math.max(dp[i - 1][0] + map[i], map[i]);
                ans = Math.max(ans, map[i]);

                for(int j = 1; j <= k; j++) {
                    if(dp[i - 1][j] == -INF) continue;
        
                    dp[i][j] = dp[i - 1][j] + map[i];
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            else {
                dp[i][1] = Math.max(dp[i - 1][0] + map[i], map[i]);
                ans = Math.max(ans, dp[i][1]);

                for(int j = 2; j <= k; j++) {
                    if(dp[i - 1][j - 1] == -INF) continue;
                    dp[i][j] = dp[i - 1][j - 1] + map[i];
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        System.out.print(ans);
    }
}