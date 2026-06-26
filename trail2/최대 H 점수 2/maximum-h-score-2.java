import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MIN_VALUE;

        for(int h = 0; h <= 100; h++) {
            int cnt = 0;
            int oneCount = 0;


            for(int j = 0; j < n; j++) {
                if(arr[j] >= h) cnt++;
                else if(h - arr[j] == 1) oneCount++;
            }

            if(cnt >= h) ans = Math.max(ans, h);
            else if((h - cnt) <= oneCount && oneCount <= l) ans = Math.max(ans, h);
        }

        System.out.print(ans);
    }
}