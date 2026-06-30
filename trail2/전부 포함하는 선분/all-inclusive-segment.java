import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] x1 = new int[n];
        int[] x2 = new int[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1[i] = Integer.parseInt(st.nextToken());
            x2[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            int a = Integer.MAX_VALUE;
            int b = Integer.MIN_VALUE;

            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                a = Math.min(x1[j], a);
                b = Math.max(x2[j], b);
            }

            ans = Math.min(ans, b - a);
        }

        System.out.print(ans);
    }
}