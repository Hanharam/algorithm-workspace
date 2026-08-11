import java.io.*;
import java.util.*;

class Dress {
    int s, e, v;
    public Dress(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Dress[] dresses = new Dress[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            dresses[i] = new Dress(s, e, v);
        }

        // dp[i][j]: i번째 날에 j번 옷을 입었을 때의 최대 만족도
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }

        // 1. 첫째 날 초기화 (첫 날은 만족도 차이가 없으므로 0)
        for (int j = 1; j <= n; j++) {
            if (dresses[j].s <= 1 && 1 <= dresses[j].e) {
                dp[1][j] = 0; 
            }
        }

        // 2. 둘째 날부터 M번째 날까지 DP 점화식 적용
        for (int i = 2; i <= m; i++) {
            for (int j = 1; j <= n; j++) { // 오늘(i일) 입을 옷 j
                // 오늘 이 옷을 입을 수 있는 기간인지 확인
                if (i < dresses[j].s || i > dresses[j].e) continue;

                for (int k = 1; k <= n; k++) { // 어제(i-1일) 입었던 옷 k
                    // 어제 k번 옷을 입는 것이 가능했는지 확인
                    if (dp[i - 1][k] != -1) {
                        int diff = Math.abs(dresses[j].v - dresses[k].v);
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + diff);
                    }
                }
            }
        }

        // 3. 마지막 날(M일)의 만족도 중 최댓값 탐색
        int maxSatisfaction = -1;
        for (int j = 1; j <= n; j++) {
            maxSatisfaction = Math.max(maxSatisfaction, dp[m][j]);
        }

        System.out.println(maxSatisfaction);
    }
}
