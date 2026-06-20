import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 2; j < n; j++) {
                int sum = a[i] + a[j];
                max = Math.max(max, sum);
            }
        }

        System.out.print(max);
    }
}