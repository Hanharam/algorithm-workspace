import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] arr;
    public static long sum = 0;

    public static long[] L, R;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        L = new long[n + 1];
        R = new long[n + 2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        for(int i = 1; i <= n; i++) {
            L[i] = L[i - 1] + arr[i];
        }

        for(int i = n; i >= 1; i--) {
            R[i] = R[i + 1] + arr[i];
        }

        Long ans = 0l;
        for(int i = 2; i <= n - 2; i++) {
            if(L[i] == sum/2 && R[i + 1] == sum/2) {

                int cntL = 0;
                for(int j = 1; j < i; j++) {
                    if(L[j] == sum/4 && R[j + 1] - R[i + 1] == sum/4) cntL++;
                }

                int cntR = 0;
                for(int j = i + 1; j < n; j++) {
                    if(R[j + 1] == sum/4 && L[j] - L[i] == sum/4) cntR++;
                }

                ans += cntL * cntR;
            }
        }
        System.out.print(ans);
    }
}