import java.util.*;
import java.io.*;

public class Main {
    public static int n;

    public static long count(long mid) {
        return mid - (mid/3 + mid/5 - mid/15);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        long ans = 0;

        long left = 1;
        long right = 2000000000;
        while(left <= right) {
            long mid = (left + right) / 2;

            if(count(mid) >= n) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.print(ans);
    }
}