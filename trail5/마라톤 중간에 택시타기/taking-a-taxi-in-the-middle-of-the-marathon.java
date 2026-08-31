import java.util.*;
import java.io.*;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Pair[] pairs = new Pair[n + 1];

        int[] L = new int[n + 1];
        int[] R = new int[n + 1];

        L[1] = 0;
        R[n] = 0;

        StringTokenizer st;
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            pairs[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i = 2; i <= n; i++) {
            L[i] = L[i - 1] + Math.abs(pairs[i].x - pairs[i - 1].x) + Math.abs(pairs[i].y - pairs[i - 1].y);
        }

        for(int i = n - 1; i > 0; i--) {
            R[i] = R[i + 1] + Math.abs(pairs[i + 1].x - pairs[i].x) + Math.abs(pairs[i + 1].y - pairs[i].y);
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 2; i <= n - 1; i++) {
            ans = Math.min(ans, L[i - 1] + R[i + 1] + Math.abs(pairs[i - 1].x - pairs[i + 1].x) + Math.abs(pairs[i - 1].y - pairs[i + 1].y));
        }

        System.out.print(ans);
    }
}