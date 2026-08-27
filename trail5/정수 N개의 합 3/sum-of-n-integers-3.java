import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][n + 1];
        int[][] prefixSum = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i - 1][j - 1] + arr[i][j];
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 1; i + k - 1 <= n; i++) {
            for(int j = 1; j + k - 1 <= n; j++) {
                int x2 = i + k - 1;
                int y2 = j + k - 1;
                ans = Math.max(ans, prefixSum[x2][y2] - prefixSum[x2][j - 1] - prefixSum[i - 1][y2] + prefixSum[i - 1][j - 1]);
            }
        }
        System.out.print(ans);
    }
}