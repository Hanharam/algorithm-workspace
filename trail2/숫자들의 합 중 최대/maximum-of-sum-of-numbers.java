import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;

        for(int i = x; i <= y; i++) {
            int sum = 0;
            int num = i;
            while(num > 0) {
                sum += num % 10;
                num = num / 10;
            }
            max = Math.max(sum, max);
        }

        System.out.print(max);
    }
}