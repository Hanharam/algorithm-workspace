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

        int[] cnt = new int[101];

        for(int i = 0; i < n; i++) {
            for(int j = x1[i]; j <= x2[i]; j++) {
                cnt[j]++;
            }
        }

        boolean isTrue = false;
        for(int i = 0; i < 101; i++) {
            if(cnt[i] == n) isTrue = true;
        }

        if(isTrue) System.out.print("Yes");
        else System.out.print("No");
    }
}