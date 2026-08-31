import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 100000;
    public static int n;

    public static long[] arr = new long[MAX_N];
    public static long[] L = new long[MAX_N];
    public static long[] R = new long[MAX_N];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        long totalSum = 0;
        for(int i = 0; i < n; i++) {
            totalSum += arr[i];
        }

        if(totalSum % 4 != 0) {
            System.out.print(0);
            System.exit(0);
        }

        long targetSum = totalSum / 4;

        L[0] = 0;
        long sum = arr[0];
        long cnt = (sum == targetSum) ? 1 : 0;
        for(int i = 1; i < n; i++) {
            sum += arr[i];

            // 합이 2 * targetSum이 되면
            // 2개의 구간을 나눌 수 있는 가능성이 있음
            if(sum == 2 * targetSum) L[i] = cnt;

            // 합이 targetSum 인 경우
            // cnt 값 갱신
            if(sum == targetSum) cnt++;
        }

        R[n - 1] = 0;
        sum = arr[n - 1];
        cnt = (sum == targetSum) ? 1 : 0;
        for(int i = n - 2; i >= 0; i--) {
            sum += arr[i];

            if(sum == 2 * targetSum) R[i] = cnt;

            if(sum == targetSum) cnt++;
        }

        long ans = 0;
        for(int i = 1; i < n - 1; i++) 
            ans += (long) L[i] * R[i + 1];
        System.out.print(ans);
    }
}