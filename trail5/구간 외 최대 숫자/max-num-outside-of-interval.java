import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int[] L = new int[n + 1];
        int[] R = new int[n + 2];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++) {
            L[i] = Math.max(L[i - 1], arr[i]);
        }

        for(int i = n; i >= 1; i--) {
            R[i] = Math.max(R[i + 1], arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int ans = Math.max(L[a - 1], R[b + 1]);
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}