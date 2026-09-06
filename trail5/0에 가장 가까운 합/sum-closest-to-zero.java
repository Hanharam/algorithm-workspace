import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int ans = Integer.MAX_VALUE;

        int i = 0;
        int j = n - 1;
        while(i < j) {
            int sum = arr[i] + arr[j];

            ans = Math.min(ans, Math.abs(sum));

            if(sum == 0) break;
            else if(sum < 0) i++;
            else j--;
        }
        System.out.print(ans);
    }  
}