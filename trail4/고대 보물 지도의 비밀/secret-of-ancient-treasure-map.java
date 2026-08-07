import java.io.*;
import java.util.*;

public class Main {
    public static int n, k;
    public static int[] map = new int[100000];
    public static int[][] max = new int[11][100001];

    public static void init() {
        for(int i = 0; i <= k; i++) {
            for(int j = 0; j <= n; j++) {
                max[i][j] = Integer.MIN_VALUE;
            }
        }
        max[0][0] = 0;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        init();

        for(int i = 1; i <= n; i++) {
            if(map[i] >= 0) {
                max[0][i] = Math.max(map[i], max[0][i - 1] == Integer.MIN_VALUE ? Integer.MIN_VALUE : max[0][i - 1] + map[i]);

                for(int j = 1; j <= k; j++) {
                    if(max[j][i - 1] != Integer.MIN_VALUE) {
                        max[j][i] = max[j][i - 1] + map[i];
                    }
                }
            } else {
                for(int j = 1; j <= k; j++) {
                    int prev = max[j - 1][i - 1] == Integer.MIN_VALUE ? Integer.MIN_VALUE : max[j - 1][i - 1] + map[i];

                    if(j == 1) {
                        max[1][i] = Math.max(map[i], prev);
                    } else {
                        max[j][i] = prev;
                    }
                }
            }
        }

        int ans = Integer.MIN_VALUE;

        for(int i = 0; i <= k; i++) {
            for(int j = 1; j <= n; j++) {
                ans = Math.max(max[i][j], ans);
            }
        }

        System.out.print(ans);
    }
}