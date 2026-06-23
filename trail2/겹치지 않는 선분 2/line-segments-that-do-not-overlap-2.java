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

        int ans = 0;
        for(int i = 0; i < n; i++) {
            boolean isTrue = true;
            for(int j = 0; j < n; j++) {
                if(j == i) continue;

                if(x1[i] > x1[j] && x2[i] < x2[j]) isTrue = false;
                else if(x1[i] < x1[j] && x2[i] > x2[j]) isTrue = false;
            }
            if(isTrue) ans++;
        }

        System.out.print(ans);
    }
}