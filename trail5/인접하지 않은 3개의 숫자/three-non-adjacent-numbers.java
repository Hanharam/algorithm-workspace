import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] L = new int[n + 1];
        int[] R = new int[n + 2];

        for(int i = 1; i <= n; i++) {
            L[i] = Math.max(arr[i], L[i - 1]);
        }

        for(int i = n; i >= 1; i--) {
            R[i] = Math.max(arr[i], R[i + 1]);
        }

        int ans = 0;
        for(int i = 3; i <= n - 2; i++) {
            int maxL = L[i - 2];
            int maxR = R[i + 2];

            ans = Math.max(arr[i] + maxR + maxL, ans);
        }
        System.out.print(ans);
    }
}