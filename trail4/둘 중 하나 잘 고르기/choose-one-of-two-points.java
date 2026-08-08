import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] red = new int[201];
    public static int[] blue = new int[201];

    public static int[][] dp = new int[201][201]; // red, blue

    public static void init() {
        dp[0][0] = 0;

        for(int i = 1; i <= 2 * n; i++) {
            for(int j = 1; j <= 2 * n; j++) {
                dp[i][j] = -1;
            }
            dp[i][0] = red[i] + dp[i - 1][0];
            dp[0][i] = blue[i] + dp[0][i - 1];
        }        
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= 2 * n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            red[i] = Integer.parseInt(st.nextToken());
            blue[i] = Integer.parseInt(st.nextToken());
        }

        init();
        

        int ans = -1;
        for(int i = 1; i <= 2 * n; i++) {
            for(int j = 1; j <= 2 * n; j++) {
                if(i > n || j > n) continue;
                dp[i][j] = Math.max(dp[i - 1][j] + red[i + j], dp[i][j - 1] + blue[i + j]);
                
                if(i == n && j == n) ans = Math.max(dp[i][j], ans);
            }
        }

        // for(int i = 0; i <= 2*n; i++) {
        //     for(int j = 0; j <= 2*n; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.print(ans);
    }
}