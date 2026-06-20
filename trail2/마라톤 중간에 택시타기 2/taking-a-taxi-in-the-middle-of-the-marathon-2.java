import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] x = new int[n];
        int[] y = new int[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int minDist = Integer.MAX_VALUE;

        for(int i = 1; i < n - 1; i++) {
            int curDist = 0;
            int p = 0;
            for(int j = 1; j < n; j++) {
                if(j == i) continue;
                curDist += Math.abs(x[j] - x[p]) + Math.abs(y[j] - y[p]);
                p = j;
            }
            minDist = Math.min(curDist, minDist);
        }
        System.out.print(minDist);
    }
}