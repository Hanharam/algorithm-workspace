import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int[] total = new int[m + 1];
        int[] window = new int[m + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total[arr[i]]++;
        }

        for(int i = 1; i <= m; i++) {
            if(total[i] < 2) {
                System.out.print(-1);
                return;
            }
        }

        int inside = 0;
        int outside = m;

        int ans = Integer.MAX_VALUE;
        int j = 0;
        for(int i = 1; i <= n; i++) {
            while(j + 1 <= n && inside < m) { 
                if(window[arr[j + 1]]++ == 0) inside++;
                if(total[arr[j + 1]]-- == 1) outside--;
                j++;
            }

            if(inside == m && outside == m) {
                ans = Math.min(ans, j - i + 1);
            }

            if(window[arr[i]]-- == 1) inside--;
            if(total[arr[i]]++ == 0) outside++;
        }
        if(ans == Integer.MAX_VALUE) ans = -1;
        System.out.print(ans);
    }
}