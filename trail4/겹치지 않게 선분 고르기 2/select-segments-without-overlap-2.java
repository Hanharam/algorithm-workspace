import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair other) {
        return this.x - other.x;
    }
}

public class Main {
    public static int n;
    public static Pair[] lines = new Pair[1000];

    public static int[] dp = new int[1000];

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            lines[i] = new Pair(x, y);
        }

        Arrays.sort(lines, 0, n);

        for(int i = 0; i < n; i++) {
            dp[i] = 1;

            for(int j = 0; j < i; j++) {
                int x1I = lines[i].x;
                int x2J = lines[j].y;

                if(x2J < x1I) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans = Math.max(dp[i], ans);
        }

        System.out.print(ans);
    }
}