import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] arr = new int[1000];
    public static int[] dp = new int[1000];

    public static void initialize() {
        Arrays.fill(dp, 1);
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
                if(arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = 0;
        for(int num : dp) {
            ans = Math.max(ans, num);
        }
        System.out.print(ans);
    }
}