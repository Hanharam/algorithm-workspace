import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[n + 1];
        int[] prefixSum = new int[n + 1];

        Arrays.fill(arr, false);
        for(int i = 0; i < b; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num] = true;
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 1; i + k - 1 <= n; i++) {
            int cnt = 0;
            for(int j = 0; j < k; j++) {
                if(arr[i + j]) cnt++;
            }
            ans = Math.min(ans, cnt);
        }

        System.out.print(ans);
    }
}