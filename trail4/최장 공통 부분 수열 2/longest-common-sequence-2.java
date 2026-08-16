import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static char[] a;
    public static char[] b;

    public static int[][] dp = new int[1001][1001];
    public static int[][] be = new int[1001][1001];

    public static ArrayList<Character> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = (" " + br.readLine()).toCharArray();
        b = (" " + br.readLine()).toCharArray();

        n = a.length - 1;
        m = b.length - 1;

        // 같으면 대각선에서 + 1, 다르면 위 아래 에서 큰 숫자 가지고 오기
        // 1 : 대각선 , 2 : 왼쪽 , 3 : 위쪽

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(a[i] == b[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    be[i][j] = 1;
                }
                else if(dp[i - 1][j] > dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j];
                    be[i][j] = 3;
                }
                else {
                    dp[i][j] = dp[i][j - 1];
                    be[i][j] = 2;
                }
            }
        }

        if(dp[n][m] > 0) {
        int x = n;
        int y = m;
        while(true) {
            if(x == 0 || y == 0) break;

            if(be[x][y] == 1) {
                arr.add(b[y]);
                x--;
                y--;
            }
            else if(be[x][y] == 2) {
                y--;
            }
            else if(be[x][y] == 3) {
                x--;
            }
        }

        while(!arr.isEmpty()) {
            System.out.print(arr.remove(arr.size() - 1));
        }
        }
        else System.out.print(" ");
    }
}