import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{

        int n = Integer.parseInt(br.readLine());

        int[] a = input(n);
        int[] b = input(n);

        System.out.print(isSameElements(a, b, n));
    }

    public static int[] input(int n) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[n];

        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        return num;
    }

    public static String isSameElements(int[] a, int[] b, int n) {
        Arrays.sort(a);
        Arrays.sort(b);

        for(int i = 0; i < n; i++) {
            if(a[i] != b[i]) return "No";
        }

        return "Yes";
    }
}