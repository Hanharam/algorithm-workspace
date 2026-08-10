import java.io.*;
import java.util.*;

public class Main {
    public static String n;
    public static long[][][] dp;
    public static long MOD = 1000000007;

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = br.readLine();

        dp = new long[n.length()][3][2];
        for(int i = 0; i < n.length(); i++) {
            for(int j = 0; j < 3; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // 0번째 인덱스, 현재 나머지 0, 369포함 안됨(0), N의 접두사와 일치함
        long answer = solve(0, 0, 0, true);

        answer = (answer - 1 + MOD) % MOD;
        
        System.out.print(answer);
    }

    public static long solve(int idx, int mod3, int has369, boolean isTight) {
        if(idx == n.length()) {
            if(has369 == 1 || mod3 == 0) return 1;
            return 0;
        }
        
        // 이미 계산된 값이 있으면 메모이제이션 반환
        if(!isTight && dp[idx][mod3][has369] != -1) {
            return dp[idx][mod3][has369];
        }

        long count = 0;

        int limit = isTight ? (n.charAt(idx) - '0') : 9;

        for(int d = 0; d <= limit; d++) {
            int nextMod3 = (mod3 + d) % 3;
            int nextHas369 = has369 | ((d == 3 || d == 6 || d == 9) ? 1 : 0);
            boolean nextTight = isTight && (d == limit);

            count = (count + solve(idx + 1, nextMod3, nextHas369, nextTight)) % MOD;
        }

        if(!isTight) {
                dp[idx][mod3][has369] = count;
            }

        return count;
    }
}