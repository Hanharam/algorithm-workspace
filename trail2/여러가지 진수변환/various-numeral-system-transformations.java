import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int number = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] digit = new int[20];
        int cnt = 0;
        while(true) {
            if(number < n) {
                digit[cnt++] = number;
                break;
            }

            digit[cnt++] = number % n;
            number = number / n;
        }

        for(int i = cnt - 1; i >= 0; i--) {
            System.out.print(digit[i]);
        }
    }
}