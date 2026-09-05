import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;

        int sumVal = 0;
        int j = 0;
        for(int i = 1; i <= n; i++) {
            
            while(j + 1 <= n && sumVal < s) {
                sumVal += arr[j + 1];
                j++;
            }

            if(sumVal < s) break;

            ans = Math.min(ans, j - i + 1);
            sumVal -= arr[i];
        }

        if(ans == Integer.MAX_VALUE) ans = -1;
        System.out.print(ans);
    }
}