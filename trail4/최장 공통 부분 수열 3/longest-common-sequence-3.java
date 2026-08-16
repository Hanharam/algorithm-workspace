import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[] a, b;
    public static int[][] dp;

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n + 2];
        b = new int[m + 2];

        TreeSet<Integer> set = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            set.add(a[i]);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            set.add(b[i]);
        }

        ArrayList<Integer> values = new ArrayList<>(set);

        int K = values.size();

        HashMap<Integer, Integer> index = new HashMap<>();

        for(int i = 0; i < K; i++) {
            index.put(values.get(i), i);
        }

        dp = new int[n + 2][m + 2];

        for (int i = n; i >= 1; i--) {
            for (int j = m; j >= 1; j--) {

                if (a[i] == b[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] =
                            Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        int[][] nextA = new int[n + 2][K];
        int[][] nextB = new int[m + 2][K];

        Arrays.fill(nextA[n + 1], -1);
        Arrays.fill(nextB[m + 1], -1);

        for(int i = n; i >= 1; i--) {
            System.arraycopy(
                nextA[i + 1], 0,
                nextA[i], 0,
                K
            );

            nextA[i][index.get(a[i])] = i;
        }

        for(int i = m; i >= 1; i--) {
            System.arraycopy(
                nextB[i + 1], 0,
                nextB[i], 0,
                K
            );

            nextB[i][index.get(b[i])] = i;
        }

        ArrayList<Integer> answer = new ArrayList<>();

        int x = 1;
        int y = 1;

        int len = dp[1][1];

        while (len > 0) {

            // 작은 값부터 확인
            for (int k = 0; k < K; k++) {

                int p = nextA[x][k];
                int q = nextB[y][k];

                // 둘 중 하나에 존재하지 않음
                if (p == -1 || q == -1)
                    continue;

                // 이 값을 선택해도 최장 길이를 유지할 수 있는가?
                if (1 + dp[p + 1][q + 1] == len) {

                    answer.add(values.get(k));

                    x = p + 1;
                    y = q + 1;

                    len--;

                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int v : answer) {
            sb.append(v).append(' ');
        }

        System.out.println(sb);
    }
}