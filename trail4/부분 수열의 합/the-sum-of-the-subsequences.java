import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[] arr = new int[100];
    public static int[] dp = new int[10001];

    public static void init() {
        Arrays.fill(dp, Integer.MIN_VALUE);
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
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init();

        for(int i = 0; i < n; i++) {
            int num = arr[i];

            for(int j = m; j >= 1; j--) {
                if(j - num < 0 || dp[j - num] == Integer.MIN_VALUE) continue;
                dp[j] = Math.max(dp[j], dp[j - num] + 1);
            }
        }

        System.out.print(dp[m] > 0 ? "Yes" : "No");
    }
}