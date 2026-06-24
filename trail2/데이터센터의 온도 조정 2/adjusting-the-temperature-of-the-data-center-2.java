import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());


        int[] a = new int[n];
        int[] b = new int[n];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());

            min = Math.min(min, a[i]);
            max = Math.max(max, b[i]);
        }

        int answer = Integer.MIN_VALUE;
        for(int i = min - 1; i <= max + 1; i++) {
            int score = 0;

            for(int j = 0; j < n; j++) {
                if(i < a[j]) score += c;
                else if(i <= b[j]) score += g;
                else score += h;
            }

            answer = Math.max(answer, score);
        }

        System.out.print(answer);
        
    }
}