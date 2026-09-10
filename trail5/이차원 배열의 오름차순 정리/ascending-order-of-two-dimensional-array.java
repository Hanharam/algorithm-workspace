import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static int[][] arr = new int[6][6];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        long left = 1;
        long right = (long) n * n;
        long ans = 0;

        while(left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for(int i = 1; i <= n; i++) {
                count += Math.min(mid/i, n);
            }

            if(count >= k) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.print(ans);
    }
}