import java.io.*;
import java.util.*;

class Gem {
    int v, w;

    public Gem(int w, int v) {
        this.v = v;
        this.w = w;
    }
}
// 무게를 올려가면서 거기서 최적을 찾기

public class Main {
    public static final int MIN_NUM = Integer.MIN_VALUE;

    public static int n, m;
    public static Gem[] gems = new Gem[100];
    public static int[] dp = new int[10001];

    public static void init() {
        for(int i = 0; i <= m; i++) {
            dp[i] = MIN_NUM;
        }
        dp[0] = 0;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            gems[i] = new Gem(w, v);
        }

        init();

        for(int i = 1; i <= m; i++) {

            for(int j = 0; j < n; j++) {
                int w = gems[j].w;
                int v = gems[j].v;

                if(i < w || dp[i - w] == MIN_NUM) continue;

                dp[i] = Math.max(dp[i], dp[i - w] + v);
            }
        }
        int ans = 0;
        for(int i = 0; i <= m; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.print(ans);
    }
}