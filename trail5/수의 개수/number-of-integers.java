import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] arr = new int[100000];

    public static int lowerBound(int target) {
        int ans = n;
        int left = 0;
        int right = n - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] >= target) {
                right = mid - 1;
                ans = Math.min(ans, mid);
            }
            else if(arr[mid] < target) left = mid + 1;
        }
        return ans;
    }

    public static int upperBound(int target) {
        int left = 0;
        int right = n - 1;
        int ans = n;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] > target) {
                right = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                left = mid + 1;
            }
        }
        return ans;
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

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            int target = Integer.parseInt(br.readLine());

            int low = lowerBound(target);
            int up = upperBound(target);

            sb.append(up - low).append("\n");
        }
        System.out.print(sb);
    }
}
