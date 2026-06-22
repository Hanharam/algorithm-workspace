import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;
        int sum = 0;

        for(int i = 0; i < 6; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            sum += a[i];
        }

        for(int i = 0; i < 6; i++) {
            for(int j = i + 1; j < 6; j++) {
                for(int k = j + 1; k < 6; k++) {
                    int sum1 = a[i] + a[j] + a[k];
                    int sum2 = sum - sum1;
                    int diff = Math.abs(sum1 - sum2);

                    min = Math.min(diff, min);
                }
            }
        }
        System.out.print(min);
    }
}