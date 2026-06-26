import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 100; i > 0; i--) {
            if (arr[1] > i || arr[n] > i) continue;

            int[] available = new int[n + 1];
            int cnt = 0;
            boolean isTrue = true;

            for(int j = 1; j <= n; j++) {
                if(arr[j] <= i) available[cnt++] = j;
            }

            for(int j = 0; j < cnt - 1; j++) {
                if(available[j + 1] - available[j] > k) {
                    isTrue = false;
                    break;
                }
            }

            if(isTrue) ans = Math.min(ans, i);
        }

        System.out.print(ans);
    }
}