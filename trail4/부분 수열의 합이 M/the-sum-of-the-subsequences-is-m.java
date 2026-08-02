import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_NUM = Integer.MAX_VALUE;

    public static int n, m;
    public static int[] arr = new int[100];
    public static int[] dp = new int[10001];

    public static void initialize() {
        for(int i = 1; i <= m; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
    }

    public static void main(String[] args)throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        initialize();

        for(int i = 0; i < n; i++) {
            int curNum = arr[i];

            for(int j = m; j >= 1; j--) {
                if(j - curNum < 0|| dp[j - curNum] == MAX_NUM) continue;

                dp[j] = Math.min(dp[j], dp[j - curNum] + 1);
            }
        }

        System.out.print(dp[m] == MAX_NUM ? -1 : dp[m]);
    }
}