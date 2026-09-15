import java.util.*;
import java.io.*;

public class Main {
    public static int n, k, l;
    public static Integer[] arr;
    
    public static boolean isPossible(int limit) {
        if(limit > n) return false;
        
        long required = 0;

        for(int i = 0; i < limit; i++) {
            if(arr[i] < limit) {
                int needed = limit - arr[i];

                if(needed > k) return false;
                required += needed;
            }
        }
        return required <= (long) k * l;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        arr = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int answer = 0;
        int left = 0;
        int right = 100000;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(isPossible(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.print(answer);
    }
}
