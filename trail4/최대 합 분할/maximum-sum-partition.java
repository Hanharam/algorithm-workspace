import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] arr = new int[101];
    public static int[] dp;

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalSum = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            totalSum += arr[i];
        }

        // dp[i] : (A 그룹의 합) - (B 그룹의 합) = i 일 때, A 그룹 합의 최댓값
        dp = new int[totalSum + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for(int i = 0; i < n; i++) {
            int x = arr[i];
            int[] nextDp = dp.clone();

            for(int diff = 0; diff <= totalSum; diff++) {
                if(dp[diff] == -1) continue;

                // 1. A에 넣기
                if(diff + x <= totalSum) {
                    nextDp[diff + x] = Math.max(nextDp[diff + x], dp[diff] + x);
                }

                // 2. B에 넣기
                if(diff >= x) {
                    nextDp[diff - x] = Math.max(nextDp[diff - x], dp[diff]);
                } else {
                    nextDp[x - diff] = Math.max(nextDp[x - diff], dp[diff] - diff + x);
                }
            }
            dp = nextDp;
        }

        System.out.print(dp[0]);
    }
}

