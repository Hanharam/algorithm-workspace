import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] arr = new int[100001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        int j = 1;
        int sumVal = 0;
        for(int i = 1; i <= n; i++) {
            while(j <= n && sumVal < m) {
                sumVal += arr[j];
                j++;
            }

            if(sumVal == m) ans++;
            
            sumVal -= arr[i];
        }

        System.out.print(ans);
    }
}