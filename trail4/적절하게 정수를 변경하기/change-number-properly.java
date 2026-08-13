import java.io.*;
import java.util.*;

public class Main {
    public static final int INT_MIN = Integer.MIN_VALUE;
    public static final int MAX_K = 4;
    public static final int MAX_M = 100;
    public static final int MAX_N = 500;

    // dp[i][j] :
    // 마지막으로 놓은 블록의 끝 위치가 i이고
    // 지금까지 놓은 블록의 수가 j개일 때
    // 얻을 수 있는 최대 유사도
    public static int[][] dp = new int[MAX_N + 1][MAX_M + 2];

    public static int n, m;
    public static int[] a = new int[MAX_N + 1];

    public static void init() {
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m + 1; j++) {
                dp[i][j] = INT_MIN;
            }
        }

        dp[0][0] = 0;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        init();

        for(int i = 1; i <= n; i++) {
            // 정확히 i번째 숫자를 마지막으로
            // 그 동안 블록을 총 j개 사용했을 때
            // 얻을 수 있는 최대 유사도를 계산

            // 가장 마지막으로 놓은 블록의 위치를 [l, i]라 했을 때
            // 해당 구간에 전부 k로 채워진 블록을 사용한 경우를 고려

            for(int j = 1; j <= m + 1; j++) {
                for(int k = 1; k <= MAX_K; k++) {
                    int similarity = 0;

                    for(int l = i; l >= 1; l--) {
                        similarity += (a[l] == k ? 1 : 0);

                        // [l, i] 구간에 전부 k로 채워진 블록을 하나 추가한 경우
                        // 지금까지의 사용한 블록의 수가 j가 되기 위해서는
                        // l - i번째까지 사용한 블록의 수가 j - 1이어야 하므로
                        // dp[l - 1][j - 1]에
                        // [l, i] 구간에 전부 k로 채워진 블록을 하나 추가했을 때
                        // 얻을 수 있는 유사도를 더한 값을 비교해볼 수 있음
                        dp[i][j] = Math.max(dp[i][j], dp[l - 1][j - 1] + similarity);
                    }
                }
            }
        }

        // n개의 숫자에 대해 전부 고려했을 때
        // 사용한 블록의 수가 m + 1을 넘지 않는 경우 중
        // 가장 높은 유사도를 얻을 수 있는 경우를 선택

        int ans = 0;

        for(int j = 1; j <= m + 1; j++)
            ans = Math.max(ans, dp[n][j]);

        System.out.println(ans);
    }
}