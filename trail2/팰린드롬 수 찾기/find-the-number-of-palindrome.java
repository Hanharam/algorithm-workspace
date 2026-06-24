import java.io.*;
import java.util.*;

public class Main {
    public static boolean isPal(int n) {
        int[] a = new int[7];
        int cnt = 0;

        while(n > 0) {
            a[cnt++] = n % 10;
            n = n / 10;
        }

        boolean isTrue = true;
        for(int i = 0; i < cnt/2; i++) {
            if(a[i] != a[cnt - i - 1]) isTrue = false;
        }

        return isTrue;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for(int i = x; i <= y; i++) {
            if(isPal(i)) cnt++;
        }
        System.out.print(cnt);
    }
}