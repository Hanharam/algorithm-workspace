import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0; i <= n - t; i++) {
            int sum = 0;
            for(int j = 0; j < t; j++) {
                sum += Math.abs(a[i + j] - h);
            }
            min = Math.min(min, sum);
        }

        System.out.print(min);
    }
}