import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }


        int min = Integer.MAX_VALUE;

        for(int i = (a[0] + 1) / 2; i <= b[0] / 2; i++) {
            int x = i;
            boolean isTrue = true;

            for(int j = 0; j < n; j++) {
                x = x * 2;
                if(!(x >= a[j] && x <= b[j])) {
                    isTrue = false;
                    break;
                }
            }

            if(isTrue) min = Math.min(min, i);
        }
        System.out.print(min);
    }
}