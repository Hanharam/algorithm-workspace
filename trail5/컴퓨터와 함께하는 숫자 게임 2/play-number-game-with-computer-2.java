import java.util.*;
import java.io.*;

public class Main {
    public static long m;
    public static long a, b;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Long.parseLong(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        long min = Long.MAX_VALUE;
        long max = 0;

        for (long x = a; x <= b; x++) {

            long left = 1;
            long right = m;
            long cnt = 0;

            while (left <= right) {
                long mid = (left + right) / 2;
                cnt++;

                if (mid == x) {
                    break;
                }

                if (mid < x) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
        }
        System.out.print(min + " " + max);
    }
}
