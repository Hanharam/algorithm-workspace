import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] h = new int[n];
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, h[i]);
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < max; i++) {
            int cnt = 0;
            boolean inMass = false;

            for(int j = 0; j < n; j++) {
                if(h[j] > i) {
                    if(!inMass) {
                        cnt++;
                        inMass = true;
                    }
                }
                else {
                    inMass = false;
                }
            }

            ans = Math.max(cnt, ans);
        }
        System.out.print(ans);
    }
}