import java.io.*;
import java.util.*;

public class Main {
    public static final int OFFSET = 20;
    public static final int UPPER = 40;
    
    public static int n, m;
    public static int[] a = new int[100];
    public static long[][] dp;
    
    public static boolean inBound(int x) {
        return 0 <= x && x <= 40;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new long[n][UPPER + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][OFFSET + a[0]]++;
        dp[0][OFFSET - a[0]]++;
        for(int i = 1; i < n; i++) {
            int num = a[i];

            for(int j = 0; j <= UPPER; j++) {
                if(dp[i - 1][j] == 0) continue;

                if(inBound(j - num)) dp[i][j - num] += dp[i - 1][j];
                if(inBound(j + num)) dp[i][j + num] += dp[i - 1][j];
            }
        }

        System.out.print(dp[n - 1][OFFSET + m]);
    }
}