import java.io.*;
import java.util.*;

public class Main {
    public static int getDistance(int a, int b, int n) {
        int diff = Math.abs(a - b);

        return Math.min(diff, n - diff);
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] r1 = new int[3];
        int[] r2 = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++) {
            r1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++) {
            r2[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    boolean match1 = (getDistance(i, r1[0], n) <= 2) && 
                                     (getDistance(j, r1[1], n) <= 2) && 
                                     (getDistance(k, r1[2], n) <= 2);
                                     
                    boolean match2 = (getDistance(i, r2[0], n) <= 2) && 
                                     (getDistance(j, r2[1], n) <= 2) && 
                                     (getDistance(k, r2[2], n) <= 2);

                    if(match1 || match2) cnt++;
                }
            }
        }
        System.out.print(cnt);
    }
}