import java.io.*;
import java.util.*;

class Gem {
    int w, v;

    public Gem(int w, int v) {
        this.w = w;
        this.v = v;
    }
}

public class Main {
    public static int n, m;
    public static Gem[] gems = new Gem[100];

    public static int[] dp = new int[10001];

    public static void main(String[] args) throws IOException{
        // Please write your code here.
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

        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

            for(int j = 0; j < n; j++) {
                int w = gems[j].w;
                int v = gems[j].v;

                for(int i = m; i >= 1; i--) {
                    if(i < w || dp[i - w] == Integer.MIN_VALUE) continue;

                    dp[i] = Math.max(dp[i], dp[i - w] + v);
                }
            }

        int answer = 0;
        for(int i = 0; i <= m; i++) {
            answer = Math.max(answer, dp[i]);
        }
        

        System.out.print(answer);
    }
}