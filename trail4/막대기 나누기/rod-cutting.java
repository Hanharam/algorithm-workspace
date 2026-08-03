import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] cost = new int[101];
    public static int[] dp = new int[101];

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for(int i = 1; i <= n; i++) {
            
            for(int j = 1; j <= n; j++) {
                int c = cost[j];

                if(i < j || dp[i - j] == Integer.MIN_VALUE) continue;

                dp[i] = Math.max(dp[i], dp[i - j] + c);
            }
        }

        System.out.print(dp[n]);
    }
}