import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] nums = new int[3];
    public static int[] dp = new int[1001];

    public static final int MIN_NUM = Integer.MIN_VALUE;

    public static void init() {
        for(int i = 0; i <= n; i++) {
            dp[i] = 0;
        }
        dp[0] = 1;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        init();

        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 5;

        for(int i = 1; i <= n; i++) {
            
            for(int j = 0; j < 3; j++) {
                if(i - nums[j] < 0 || dp[i - nums[j]] == 0) continue;

                dp[i] += dp[i - nums[j]];
            }

            dp[i] = dp[i] % 10007;
        }

        System.out.print(dp[n]);
    }
}