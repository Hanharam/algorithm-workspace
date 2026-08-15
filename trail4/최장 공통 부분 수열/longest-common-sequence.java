import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static char[] a = new char[1001];
    public static char[] b = new char[1001];

    public static int[][] dp = new int[1001][1001];

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = (" " + br.readLine()).toCharArray();
        b = (" " + br.readLine()).toCharArray();

        n = a.length;
        m = b.length;


        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(a[i] == b[j]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }


        System.out.print(dp[n - 1][m - 1]);
    }
}