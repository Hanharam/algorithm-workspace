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

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= 50; i++) {
            for(int j = 0; j <= 50; j++) {
                int st = 0;
                int nd = 0;
                int rd = 0;
                int th = 0;

                int dx = i * 2;
                int dy = j * 2;

                for(int k = 0; k < n; k++) {
                    if(x[k] < dx && y[k] > dy) st++;
                    else if(x[k] > dx && y[k] > dy) nd++;
                    else if(x[k] > dx && y[k] < dy) rd++;
                    else th++;
                }
                int maxCnt = Math.max(st, Math.max(nd, Math.max(rd, th)));
                ans = Math.min(ans, maxCnt);
            }
        }
        System.out.print(ans);
    }
}