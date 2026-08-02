import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] arr = new int[1000];
    public static int[][] dp = new int[2][1000]; // 0: 증가, 1: 감소, 2: 증가했다 감소 중

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < 2; i++) {
            Arrays.fill(dp[i], 1);
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    dp[0][i] = Math.max(dp[0][i], dp[0][j] + 1);
                }
            }
        }

        for(int i = n - 2; i >= 0; i--) {
            for(int j = n - 1; j > i; j--) {
                if(arr[i] > arr[j]) {
                    dp[1][i] = Math.max(dp[1][i], dp[1][j] + 1);
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[0][i] + dp[1][i]);
        }
        
        System.out.print(ans - 1);
    }
}
