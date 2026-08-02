import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] arr = new int[1000];
    public static int[][] dp = new int[1000][2];

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;

            for(int j = 0; j < i; j++) {

                if(arr[j] < arr[i]) 
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);

                if(arr[j] > arr[i])
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
            }

            dp[i][1] = Math.max(dp[i][1], dp[i][0]);
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i][1]);
        }
        
        System.out.print(ans);
    }
}
