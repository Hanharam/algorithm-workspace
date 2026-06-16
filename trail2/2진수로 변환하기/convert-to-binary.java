import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] digit = new int[20];

        int cnt = 0;

        while(true) {
            if(n < 2) {
                digit[cnt++] = n;
                break;
            }

            digit[cnt++] = n%2;
            n = n/2;
        }

        for(int i = cnt - 1; i > -1; i--) {
            System.out.print(digit[i]);
        }
    }
}