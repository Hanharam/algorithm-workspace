import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NUM = 100000;

    public static int n;
    public static int ans = MAX_NUM;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i <= MAX_NUM; i++) {
            int remainder = n - 5 * i;
            if(remainder >= 0 && remainder % 2 == 0) {
                ans = Math.min(ans, i + (remainder / 2));
            }
        }

        if(ans == MAX_NUM) ans = -1;

        System.out.print(ans);
    }
}