import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[m];
        int[] b = new int[m];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            for(int j = i + 1; j <= n; j++) {
                int cnt = 0;

                for(int k = 0; k < m; k++) {
                    if((i == a[k] && j == b[k]) || (i == b[k] && j == a[k])) cnt++;
                }

                ans = Math.max(ans, cnt);
            }
        }

        System.out.print(ans);
    }
}