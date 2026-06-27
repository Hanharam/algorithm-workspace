import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean isTrue = false;

        int[] x1 = new int[n];
        int[] x2 = new int[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1[i] = Integer.parseInt(st.nextToken());
            x2[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for(int j = 0; j < n; j++) {
                if(i == j) continue;

                min = Math.min(min, x2[j]);
                max = Math.max(max, x1[j]);
            }

            if(min >= max) {
                isTrue = true;
                break;
            }
        }

        if(isTrue) System.out.print("Yes");
        else System.out.print("No");
    }
}