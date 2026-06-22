import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[101];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            a[pos] += num;
        }

        int max = 0;
        for(int i = 0; i <= 100; i++) {
            int sum = 0;
            for(int j = Math.max(i - k, 0); j <= Math.min(100, i + k); j++) {
                sum += a[j];
            } 
            max = Math.max(sum, max);
        }
        System.out.print(max);

    }
}