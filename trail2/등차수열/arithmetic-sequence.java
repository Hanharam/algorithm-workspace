import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());

            min = Math.min(a[i], min);
            max = Math.max(a[i], max);
        }

        int ans = Integer.MIN_VALUE;
        for(int i = min + 1; i < max; i++) {
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    if(a[j] - i == i - a[k]) cnt++;
                }
            }
            ans = Math.max(cnt, ans);
        }
        System.out.print(ans);
    }
}