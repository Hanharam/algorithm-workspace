import java.util.*;
import java.io.*;

public class Main {
    public static final int MIN_VAL = Integer.MIN_VALUE;

    public static int n;
    public static int[] arr = new int[1001];

    public static int[][] dp = new int[1001][4];

    public static void init() {
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= 3; j++) {
                dp[i][j] = MIN_VAL;
            }
        }
        dp[0][0] = 0;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init();

        for(int i = 1; i <= n; i++) {   // i = 현재 몇 계단 
            for(int j = 0; j <= 3; j++) { // j = 1계단 몇번 사용
                // 1계단 오르기
                if(j >= 1 && dp[i - 1][j - 1] != MIN_VAL) 
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + arr[i], dp[i][j]);

                // 2계단 오르기
                if(i >= 2 && dp[i - 2][j] != MIN_VAL) {
                    dp[i][j] = Math.max(dp[i - 2][j] + arr[i], dp[i][j]);
                }
            }
        }

        int ans = MIN_VAL;
        for(int i = 0; i <= 3; i++) {
            ans = Math.max(dp[n][i], ans);
        }
        System.out.print(ans);
    }
}