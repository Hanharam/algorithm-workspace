import java.io.*;
import java.util.*;

public class Main {
    public static int n, k;
    public static char[] a = new char[1000];

    public static int[][][] dp;
    
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        a = br.readLine().toCharArray();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            if(a[i] == 'L') arr[i] = 0;
            else arr[i] = 1;
        }
        
        dp = new int[n + 1][k + 1][2]; // 0 : L, 1 : R

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= k; j++) {
                for(int k = 0; k <= 1; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        dp[0][0][0] = 0;
        // 순서, 현재 바꾼 횟수, 현재 방향이 같으면 큰 값이 좋음
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= k; j++) {
                for(int m = 0; m <= 1; m++) {
                    if(dp[i][j][m] < 0) continue;
                    int val = 0;
                    if(arr[i] == m) val = 1;
                    dp[i + 1][j][m] = Math.max(dp[i + 1][j][m], dp[i][j][m] + val);
                    val = 0;
                    if(arr[i] == (m + 1) % 2) val = 1;
                    if(j + 1 > k) continue;
                    dp[i + 1][j + 1][(m + 1) % 2] = Math.max(dp[i + 1][j + 1][(m + 1) % 2], dp[i][j][m] + val);
                }
            }
        }

        int ans = 0;
        for(int i = 0; i <= k; i++) {
            for(int j = 0; j <= 1; j++) {
                ans = Math.max(dp[n][i][j], ans);
            }
        }
        System.out.print(ans);
    }
}

// 
// 이전과 다르면 + 1
// 현재 방향과 수정의 방향이 같으면 + 1