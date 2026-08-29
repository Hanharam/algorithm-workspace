import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int ans = Integer.MIN_VALUE;

        int[][] arr = new int[n + 1][n + 1];
        int[][] prefixSum = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                prefixSum[i][j] = prefixSum[i][j - 1] + arr[i][j];
            }
        }

        for(int r = 1; r <= n; r++) {
            for(int c = 1; c <= n; c++) {

                int sum = 0;

                for(int i = Math.max(1, r - k); i <= Math.min(n, r + k); i++) {
                    
                    int remain = k - Math.abs(r - i);

                    int left = Math.max(1, c - remain);
                    int right = Math.min(n, c + remain);

                    sum += (prefixSum[i][right] - prefixSum[i][left - 1]);
                }
                ans = Math.max(ans, sum);
            }
        }

        System.out.print(ans);
    }
}