import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] arr;

    public static int lowerBound(int target) {
        int minIdx = n - 1;

        int left = 0;
        int right = n - 1;
        
        while(left <= right) {
            int mid = (left + right) / 2;


            if(target <= arr[mid]) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            } else if(arr[mid] < target) {
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

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            int idx = lowerBound(target);

            if(arr[idx] == target) sb.append(idx + 1).append("\n");
            else sb.append("-1\n");
        }
        System.out.print(sb);
    }
}