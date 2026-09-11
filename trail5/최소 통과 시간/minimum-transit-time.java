import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] tunnel;

    public static boolean isPossible(long limit) {
        long count = 0;

        for(int i = 0; i < m; i++) {
            if(tunnel[i] > limit) break;

            count += (long)limit / tunnel[i];
        }

        if(count >= n) return true;
        else return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        tunnel = new int[m];

        for(int i = 0; i < m; i++) {
            tunnel[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(tunnel);

        long left = tunnel[0];
        long right = (long)tunnel[m - 1] * n;
        long answer = Long.MAX_VALUE;

        while(left <= right) {
            long mid = (left + right) / 2;

            if(isPossible(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.print(answer);
    }
}