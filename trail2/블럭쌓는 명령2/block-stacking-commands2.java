import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[100];
        int[] b = new int[100];

        int[] block = new int[n];

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < k; i++) {
            for(int j = a[i] - 1; j < b[i]; j++) {
                block[j]++;;
            }
        }

        int max = 0;

        for(int i = 0; i < n; i++) {
            if(block[i] > max)
                max = block[i];
        }

        System.out.print(max);

    }
}