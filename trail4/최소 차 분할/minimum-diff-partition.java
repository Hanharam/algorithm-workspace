import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] arr = new int[101];

    public static int[] dp = new int[101];

    // 몇개를 참가시켰을 때 둘의 차가 최소인지 구하기 
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalSum = 0;
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            totalSum += arr[i];
        }

        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1]; 

        dp[0] = true;

        for(int i = 1; i <= n; i++) {
            for(int j = target; j >= arr[i]; j--) {
                if(dp[j - arr[i]]) {
                    dp[j] = true;
                }
            }
        }

        int maxSubsetSum = 0;

        for(int i = target; i >= 0; i--) {
            if(dp[i]) {
                maxSubsetSum = i;
                break;
            }
        }

        int minDifference = totalSum - 2*maxSubsetSum;
        System.out.print(minDifference);
    }
}

