import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] arr = new int[100000];

    public static int lowerBound(int target) {
        int minIdx = n;

        int left = 0;
        int right = n;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] >= target) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            } else {
                left = mid + 1;
            }
        }
        return minIdx;
    }

    public static int upperBound(int target) {
        int minIdx = n;

        int left = 0;
        int right = n;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] > target) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            } else {
                left = mid + 1;
            }
        }
        return minIdx;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, 0, n);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int low = lowerBound(l);
            int up = upperBound(r);

            // System.out.printf("Left = %d, Right = %d, Lower = %d, Upper = %d\n", l, r, low, up);

            sb.append(up - low).append("\n");
        }
        System.out.print(sb);
    }
}