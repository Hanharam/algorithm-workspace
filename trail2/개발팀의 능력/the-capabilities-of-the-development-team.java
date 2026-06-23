import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[5];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        for(int i = 0; i < 5; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            sum += a[i];
        }

        int answer = Integer.MAX_VALUE;
        boolean isTrue = false;

        int sum1, sum2, sum3;
        for(int i = 0; i < 5; i++) {
            for(int j = i + 1; j < 5; j++) {
                for(int l = 0; l < 5; l++) {
                    for(int k = l + 1; k < 5; k++) {
                        if(l == i || l == j || k == i || k == j) continue;

                        sum1 = a[i] + a[j];
                        sum2 = a[l] + a[k];
                        sum3 = sum - sum1 - sum2;

                        if(sum1 != sum2 && sum2 != sum3 && sum1 != sum3) {
                            int min = Math.min(sum1, Math.min(sum2, sum3));
                            int max = Math.max(sum1, Math.max(sum2, sum3));

                            answer = Math.min(answer, max - min);
                            isTrue = true;
                        }
                    }
                }
            }
        }

        if(isTrue) System.out.print(answer);
        else System.out.print(-1);
    }
}