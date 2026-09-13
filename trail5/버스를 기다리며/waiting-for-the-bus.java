import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, c;
    public static int[] arr = new int[100000];

    public static boolean isPossible(int t) {
        int count = 1;
        int passenger = 1;
        int limit = arr[0] + t;

        for(int i = 1; i < n; i++) {
            if(arr[i] <= limit && passenger < c) {
                passenger++;
                // System.out.printf("Count = %d, limit = %d, passenger = %d, 탑승 시간 = %d\n", count, limit, passenger, arr[i]);
                continue;
            }

            limit = arr[i] + t;
            count++;
            passenger = 1;
            // System.out.printf("Count = %d, limit = %d, passenger = %d, 탑승 시간 = %d\n", count, limit, passenger, arr[i]);
        }

        // System.out.printf("[Result] Time = %d, count = %d\n", t, count);

        return count <= m;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, 0, n);

        int answer = Integer.MAX_VALUE;
        int left = 0;
        int right = 1000000000;
        while(left <= right) {
            int mid = (left + right) / 2;

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