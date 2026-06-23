import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int answer = -1;
        for(int i = 0; i < n; i++) {
            int num = a[i];
            boolean explosion = false;
            
            for(int j = 0; j < n; j++) {
                if(i == j) continue;

                if(Math.abs(i - j) <= k && a[i] == a[j]) explosion = true;
            }

            if(explosion) answer = Math.max(answer, num);
        }

        System.out.print(answer);

    }
}