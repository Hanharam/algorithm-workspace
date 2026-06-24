import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MIN_VALUE;

        for(int i = 1; i <= 3; i++) {
            int score = 0;
            boolean[] cor = new boolean[4];
            cor[i] = true;

            for(int j = 0; j < n; j++) {
                boolean cur = cor[a[j]];
                cor[a[j]] = cor[b[j]];
                cor[b[j]] = cur;

                if(cor[c[j]]) score++;
            }

            ans = Math.max(ans, score);
        }

        System.out.print(ans);
    }
}