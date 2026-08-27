import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_A = 1000000;
    public static final int MAX_N = 100000;


    public static int n, q;
    public static int[] arr = new int[MAX_N + 1];
    public static int[] prefixSum = new int[MAX_A + 1];

    public static int getSum(int s, int e) {
        if(s == 0) return prefixSum[e];
        return prefixSum[e] - prefixSum[s - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefixSum[arr[i]]++;
        }

        for(int i = 1; i <= MAX_A; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }

        for(int i = 1; i <= q; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            System.out.println(getSum(l, r));
        }
    }
}