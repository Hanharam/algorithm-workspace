import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            int idx = i;

            for(int j = 0; j < m; j++) {
                sum += arr[idx];
                idx = arr[idx] - 1;
            }

            ans = Math.max(ans, sum);
        }
        System.out.print(ans);
    }
}