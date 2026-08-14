import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_NUM = 1000000000;

    public static int n;
    public static int[] init = new int[10001];
    public static int[] goal = new int[10001];
    public static int[][] dp = new int[10005][10];

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        char[] temp = br.readLine().toCharArray();
        for(int i = 1; i <= n; i++) {
            init[i] = temp[i - 1] - '0';
        }

        temp = br.readLine().toCharArray();
        for(int i = 1; i <= n; i++) {
            goal[i] = temp[i - 1] - '0';
        }

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < 10; j++) {
                dp[i][j] = MAX_NUM;
            }
        }
        dp[0][0] = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 10; j++) {
                if(dp[i][j] == MAX_NUM) continue;

                int cur = (init[i + 1] + j) % 10;

                // case 1: 시계 방향 (증가) (뒤에 마법진 회전)
                int num = (goal[i + 1] - cur + 10) % 10;
                dp[i + 1][(j + num) % 10] = Math.min(dp[i + 1][(j + num) % 10], dp[i][j] + num);

                // case 2: 반시계 방향 (감소) (현재 마법진만 회전)
                num = (cur - goal[i + 1] + 10) % 10;
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + num);
            }
        }

        // for(int i = 0; i <= n; i++) {
        //     for(int j = 0; j < 10; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < 10; i++) {
            ans = Math.min(dp[n][i], ans);
        }
        System.out.print(ans);
    }
}