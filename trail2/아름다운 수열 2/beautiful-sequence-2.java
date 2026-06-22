import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[m];

        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] check = new int[101];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            check[b[i]]++;
        }

        for(int i = 0; i <= n - m; i++) {
            int[] how = new int[101];

            boolean isTrue = true;

            for(int j = i; j < i + m; j++) {

                how[a[j]]++;

            }

            for(int k = 1; k <= 100; k++) {
                    if(check[k] != how[k]) {
                        isTrue = false;
                        break;
                    }
            }

            if(isTrue) cnt++;
        }

        System.out.print(cnt);
    }
}