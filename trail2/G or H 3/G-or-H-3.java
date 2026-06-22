import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] a = new char[100001];

        int num = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int loc = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            num = Math.max(num, loc);
            a[loc] = c;
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i <= num; i++) {
            int cur = 0;
            for(int j = i; j <= i + k; j++) {
                if(a[j] == 'G') cur += 1;
                else if(a[j] == 'H') cur += 2;
            }
            max = Math.max(cur, max);
        }
        System.out.print(max);
    }
}