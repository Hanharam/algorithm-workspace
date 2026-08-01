import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] arr = new int[1000];
    public static int[] dp = new int[1000];

    public static void initialize() {
        for(int i = 0; i < n; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        dp[0] = 0;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        initialize();

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] == Integer.MIN_VALUE) continue;

                if(i <= j + arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            ans = Math.max(dp[i], ans);
        }

        System.out.print(ans);
    }
}