import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= 10000 - k; i++) {
            int j = i + k;

            int cost = 0;

            for(int l = 0; l < n; l++) {
                if(arr[l] < i) cost += Math.abs(arr[l] - i);
                else if(arr[l] > j) cost += Math.abs(arr[l] - j);
            }

            ans = Math.min(ans, cost);
        }
        System.out.print(ans);
    }
}