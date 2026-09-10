import java.util.*;
import java.io.*;

public class Main {
    public static long s;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Long.parseLong(br.readLine());

        long maxIdx = 0;

        long left = 1;
        long right = 2_000_000_000L;

        while(left <= right) {
            long mid = (left + right) / 2;

            if((mid * (mid + 1)) / 2 <= s) {
                maxIdx = Math.max(maxIdx, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.print(maxIdx);
    }
}