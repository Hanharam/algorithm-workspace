import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        int[] y = new int[n];

        int answer = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            int maxX = Integer.MIN_VALUE;
            int maxY = Integer.MIN_VALUE;
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;

            for(int j = 0; j < n; j++) {
                if(j == i) continue;

                maxX = Math.max(maxX, x[j]);
                maxY = Math.max(maxY, y[j]);
                minX = Math.min(minX, x[j]);
                minY = Math.min(minY, y[j]);
            }

            answer = Math.min(answer, (maxX - minX) * (maxY - minY));
        }

        System.out.print(answer);
    }
}