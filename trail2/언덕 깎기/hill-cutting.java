import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= 83; i++) {
            int j = i + 17;
                int cost = 0;

                for(int k = 0; k < n; k++) {
                    if(arr[k] < i) cost += Math.pow(i - arr[k], 2);
                    else if(arr[k] > j) cost += Math.pow(arr[k] - j, 2);
                }

                ans = Math.min(ans, cost);
            
        }

        System.out.print(ans);
    }
}

