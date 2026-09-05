import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int j = 0;
        for(int i = 0; i < n; i++) {
            
            while(j < n) {
                if(sum >= s) {
                    ans = Math.min(ans, j - i);
                    break;
                }

                sum += arr[j];
                j++;
            }
            sum -= arr[i];
        }
        if(ans == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.print(ans);
    }
}