import java.util.*;
import java.io.*;
  
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        int j = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
         while(j + 1 <= n && cnt < k) {
                if(arr[j + 1] == 1) cnt++;
                j++;
            }
            
            if(cnt < k) break;

            ans = Math.min(ans, j - i + 1);
            if(arr[i] == 1) cnt--;
        }

        if(ans == Integer.MAX_VALUE) ans = -1;
        System.out.print(ans);
    }
}