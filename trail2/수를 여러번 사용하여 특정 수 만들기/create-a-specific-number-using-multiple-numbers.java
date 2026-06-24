import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());


        int ans = Integer.MIN_VALUE;
        for(int i = 0; i * a <= c; i++) {
            int cnt = i * a;

            int numB = (c - cnt) / b;

            cnt += b * numB;

            ans = Math.max(ans, cnt);
        }

        System.out.print(ans);
    }
}