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

        int aCnt = c/a;
        int bCnt = c/b;


        int ans = Integer.MIN_VALUE;
        for(int i = 0; i <= aCnt; i++) {
            for(int j = 0; j <= bCnt; j++) {
                int sum = (a * i) + (b * j);

                if(sum <= c) ans = Math.max(ans, sum);
            }
        }

        System.out.print(ans);
    }
}