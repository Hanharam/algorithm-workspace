import java.util.*;
import java.io.*;

public class Main {
    public static int k, n;
    public static int[] a;
    public static int[] treeNum;
    public static int cnt = 1;

    public static void inOrder(int idx) {
        if(idx > n) return;

        inOrder(2*idx);
        treeNum[idx] = a[cnt++];
        inOrder(2*idx + 1);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        n = (1 << k) - 1;
        a = new int[n + 1];
        treeNum = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        inOrder(1);

        for(int i = 1; i <= k; i++) {
            for(int j = (1 << (i - 1)); j <= (1 << i) -  1; j++) {
                System.out.print(treeNum[j] + " ");
            }
            System.out.println();
        }
    }
}