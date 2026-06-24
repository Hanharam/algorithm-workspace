import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;

        for(int k = 0; k < n; k++) {
            a[k] = a[k] * 2;


        for(int i = 0; i < n; i++) {
            int[] arr = new int[n-1];
            int cnt = 0;
            int sumDiff = 0;


            for(int j = 0; j < n; j++) {
                if(j != i) arr[cnt++] = a[j];
            }

            for(int j = 0; j < n - 2; j++) {
                sumDiff += Math.abs(arr[j] - arr[j + 1]);
            }

            ans = Math.min(sumDiff, ans);
        }
        a[k] = a[k]/2;
        }
        System.out.print(ans);

    }
}