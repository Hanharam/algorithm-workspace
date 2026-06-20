import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] digit = new int[10];

        String num = br.readLine();

        for(int i = 0; i < num.length(); i++) {
            digit[i] = num.charAt(i) - '0';
        }
        int maxNum = Integer.MIN_VALUE;

        for(int i = 0; i < num.length(); i++) {
            int cur = 0;
            boolean isChange = false;

            digit[i] = 1 - digit[i];            

            for(int j = 0; j < num.length(); j++) {
                cur = cur * 2 + digit[j];
            }
            maxNum = Math.max(maxNum, cur);
            digit[i] = 1 - digit[i];
        }
        System.out.print(maxNum);
    }
}
