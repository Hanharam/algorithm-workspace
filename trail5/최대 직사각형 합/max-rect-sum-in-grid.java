import java.util.*;
import java.io.*;

public class Main {

    public static int n;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = Integer.MIN_VALUE;

        for (int top = 1; top <= n; top++) {

            int[] sum = new int[n + 1];

            for (int bottom = top; bottom <= n; bottom++) {

                for (int col = 1; col <= n; col++) {
                    sum[col] += arr[bottom][col];
                }

                int current = sum[1];
                int best = sum[1];

                for (int col = 2; col <= n; col++) {
                    current = Math.max(
                            sum[col],
                            current + sum[col]
                    );

                    best = Math.max(best, current);
                }

                ans = Math.max(ans, best);
            }
        }

        System.out.println(ans);
    }
}