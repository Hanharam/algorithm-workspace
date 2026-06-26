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

        int ans = 1;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int min = Math.min(a[i], a[j]);
                int max = Math.max(a[i], a[j]);
                int cnt = 0;

                if(max - min <= k) {
                    for(int l = 0; l < n; l++) {
                        if(a[l] >= min && a[l] <= max) cnt++;
                    }
                }

                ans = Math.max(ans, cnt);
            }
        }
        System.out.print(ans);        
    }
}