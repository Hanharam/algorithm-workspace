import java.util.*;
import java.io.*;

// Two Pointer 방식

class Pair implements Comparable<Pair> {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair b) {
        if(x != b.x) return x - b.x;
        return this.y - b.y;
    }
}

public class Main {
    public static final int INT_MIN = Integer.MIN_VALUE;
    public static final int MAX_NUM = 1000;

    public static int n;
    public static int[] dp = new int[MAX_NUM + 1];

    public static int[] s = new int[MAX_NUM + 1];
    public static int[] e = new int[MAX_NUM + 1];
    public static int[] p = new int[MAX_NUM + 1];

    public static Pair[] sortedWorks = new Pair[MAX_NUM + 1];

    public static void preprocess() {
        // 알바가 끝나는 순으로 정렬
        for(int i = 0; i <= n; i++) {
            sortedWorks[i] = new Pair(e[i], i);
        }

        Arrays.sort(sortedWorks, 1, n + 1);
    }

    public static void initialize() {
        for(int i = 0; i <= n; i++) {
            dp[i] = INT_MIN;
        }

        s[0] = e[0] = p[0] = 0;
        dp[0] = 0;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            e[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++) {
            sortedWorks[i] = new Pair(0, 0);
        }

        initialize();

        preprocess();

        int maxJ = 0;

        int ptr = 1;

        for(int i = 1; i <= n; i++) {

            while(sortedWorks[ptr].x < s[i]) {
                int j = sortedWorks[ptr].y;
                if(dp[j] > dp[maxJ])
                    maxJ = j;
                
                ptr++;
            }

            dp[i] = Math.max(dp[i], dp[maxJ] + p[i]);
        }

        int answer = 0;
        for(int i = 0; i <= n; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}