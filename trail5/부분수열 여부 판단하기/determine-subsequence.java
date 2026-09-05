import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] a = new int[100001];
    public static int[] b = new int[100001];

    public static boolean isSubsequence() {
        int j = 1;

        for(int i = 1; i <= m; i++) {

            while(j <= n && a[j] != b[i]) j++;

            if(j == n + 1) return false;
            else j++;
        }

        return true;
    }

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

        if(isSubsequence()) System.out.print("Yes");
        else System.out.print("No");
    }
}