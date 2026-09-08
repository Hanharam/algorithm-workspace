import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] a = new int[100001];
    public static int[] b = new int[100001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefix = new int[m + 1];
        int[] suffix = new int[m + 2];
        int j = 1;
        for(int i = 1; i <= m; i++) {
            while(j <= n && a[j] != b[i]) {
                j++;
            }

            if(j > n) prefix[i] = n + 1;
            else {
                prefix[i] = j;
                j++;
            }
        }

        suffix[m + 1] = n + 1;
        j = n;
        for(int i = m; i >= 1; i--) {
            while(j >= 1 && a[j] != b[i]) {
                j--;
            }

            if(j < 1) suffix[i] = 0;
            else {
                suffix[i] = j;
                j--;
            }
        }

        int ans = 0;
        for(int i = 1; i <= m; i++) {
            if(prefix[i - 1] < suffix[i + 1]) ans++;
        }
        System.out.print(ans);
    }
}