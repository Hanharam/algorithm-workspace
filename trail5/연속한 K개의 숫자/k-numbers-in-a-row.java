import java.util.*;
import java.io.*;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100000;

    public static int n, k, b;
    public static int[] arr = new int[MAX_N + 1];
    public static int[] prefixSum = new int[MAX_N + 1];
    public static int ans = INT_MAX;

    public static int getSum(int s, int e) {
        return prefixSum[e] - prefixSum[s - 1];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        while(b-- > 0) {
            int x = Integer.parseInt(br.readLine());
            arr[x] = 1;
        }

        prefixSum[0] = 0;
        for(int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        for(int i = 1; i <= n - k + 1; i++)
            ans = Math.min(ans, getSum(i, i + k - 1));

        System.out.print(ans);
    }
}