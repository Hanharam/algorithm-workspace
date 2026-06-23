import java.io.*;
import java.util.*;

public class Main {
    public static int[] a = new int[6];

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        for(int i = 0; i < 6; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            sum += a[i];
        }

        int sum1, sum2, sum3;
        int answer = Integer.MAX_VALUE;

        int min, max;
        for(int i = 0; i < 6; i++) {
            for(int j = i + 1; j < 6; j++) {
                for(int l = 0; l < 6; l++) {
                    for(int k = l + 1; k < 6; k++) {
                        if(l == i || l == j || k == i || k == j) continue;
                        sum1 = a[i] + a[j];
                        sum2 = a[l] + a[k];
                        sum3 = sum - sum1 - sum2;

                        min = Math.min(sum1, Math.min(sum2, sum3));
                        max = Math.max(sum1, Math.max(sum2, sum3));

                        answer = Math.min(answer, max - min);
                    }
                }
            }
        }

        System.out.print(answer);
    }
}