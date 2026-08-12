import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] s;
    public static int[] e;
    public static int[] v;

    public static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        s = new int[n];
        e = new int[n];
        v = new int[n];

        dp = new int[m + 1][n];

        for(int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            s[i] = Integer.parseInt(st.nextToken());
            e[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());

            if(s[i] <= 1) dp[1][i] = 0;
        }
        

        for(int i = 2; i <= m; i++) {
            for(int k = 0; k < n; k++) {
                if(dp[i - 1][k] < 0) continue;
                for(int j = 0; j < n; j++) {
                    if(s[j] <= i && i <= e[j]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + Math.abs(v[k] - v[j]));
                    }
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[m][i]);
        }

        // for(int i = 0; i <= m; i++) {
        //     for(int j = 0; j < n; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        System.out.print(ans);
    }
}