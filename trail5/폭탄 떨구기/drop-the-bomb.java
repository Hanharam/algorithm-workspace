import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static int[] arr = new int[50001];

    public static boolean isPossible(int r) {
        int range = arr[1] + 2 * r;
        int count = 1;

        for(int i = 2; i <= n; i++) {
            if(arr[i] <= range) continue;
            
            range = arr[i] + 2 * r;
            count++;
        }

        // System.out.printf("R = %d, count = %d\n", r, count);

        return count <= k;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, 1, n + 1);

        int answer = Integer.MAX_VALUE;
        int left = 0;
        int right = 500000000;
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