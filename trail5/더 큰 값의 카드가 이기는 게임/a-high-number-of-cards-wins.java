import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] a, b;
    public static boolean[] used;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        a = new int[n];
        b = new int[n];
        used = new boolean[2*n + 1];
        Arrays.fill(used, false);

        for(int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(br.readLine());
            used[b[i]] = true;
        }

        int aIdx = 0;
        for(int i = 1; i <= 2 * n; i++) {
            if(!used[i]) a[aIdx++] = i;
        }

        Arrays.sort(b);

        int count = 0;
        int bIdx = 0;

        for(int i = 0; i < n; i++) {
            if(a[i] > b[bIdx]) {
                count++;
                bIdx++;
            }
        }
        System.out.print(count);
    }
}