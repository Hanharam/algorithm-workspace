import java.util.*;
import java.io.*;

class Candy implements Comparable<Candy> {
    int x, cnt;

    public Candy(int x, int cnt) {
        this.x = x;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Candy c) {
        return x - c.x;
    }
}

public class Main {
    public static final int MAX_N = 100000;

    public static int n, k;
    public static Candy[] candies = new Candy[MAX_N + 1];

    public static int getPosOfCandy(int candyIdx) {
        return candies[candyIdx].x;
    }

    public static int getNumOfCandy(int candyIdx) {
        return candies[candyIdx].cnt;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int val = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            candies[i] = new Candy(x, val);
        }

        Arrays.sort(candies, 1, n + 1);

        int ans = 0;

        int totalNums = 0;
        int j = 0;

        for(int i = 1; i <= n; i++) {
            while(j + 1 <= n && getPosOfCandy(j + 1) - getPosOfCandy(i) <= 2 * k) {
                totalNums += getNumOfCandy(j + 1);
                j++;
            }

            ans = Math.max(ans, totalNums);
            totalNums -= getNumOfCandy(i);
        }
        System.out.print(ans);
    }
}