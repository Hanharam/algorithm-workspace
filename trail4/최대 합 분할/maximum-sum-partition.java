import java.io.*;
import java.util.*;

public class Main {
    public static final int INT_MIN = Integer.MIN_VALUE;
    public static final int OFFSET = 100000;
    public static final int MAX_M = 100000;
    public static final int MAX_N = 100;
    
    public static int n, m;
    public static int[] arr = new int[MAX_N + 1];
    
    public static int[][] dp = new int[MAX_N + 1][MAX_M + 1 + OFFSET];
    
    public static void init() {
        for(int i = 0; i <= n; i++) {
            for(int j = -m; j <= m; j++) {
                dp[i][j + OFFSET] = INT_MIN;
            }
        }

        dp[0][0 + OFFSET] = 0;
    }

    public static void update(int i, int j, int prevI, int prevJ, int val) {
        if(prevJ < -m || prevJ > m || dp[prevI][prevJ + OFFSET] == INT_MIN)
            return;
        
        dp[i][j + OFFSET] = Math.max(dp[i][j + OFFSET], dp[prevI][prevJ + OFFSET] + val);
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            m += arr[i];
        }

        init();

        for(int i = 1; i <= n; i++) {
            for(int j = -m; j <= m; j++) {
                
                // 1. 그룹 A에 i 번째 원소 추가
                update(i, j, i - 1, j - arr[i], arr[i]);

                // 2. 그룹 B에 i 번째 원소 추가
                update(i, j, i - 1, j + arr[i], 0);

                // 3. 그룹 C에 i 번째 원소 추가
                update(i, j, i - 1, j, 0);
            }
        }

        System.out.print(dp[n][0 + OFFSET]);
    }
}

