import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] digit = new int[20];

        String num = br.readLine();

        for(int i = 0; i < num.length(); i++) {
            digit[i] = num.charAt(i) - '0';
        }

        int dec = 0;
        int cnt = 0;

        for(int i = 0; i < num.length(); i++) {
            dec = dec * 2 + digit[i];
        }
        dec *= 17;

        while(true) {
            if(dec < 2) {
                digit[cnt++] = dec;
                break;
            }

            digit[cnt++] = dec % 2;
            dec = dec/2;
        }
        for(int i = cnt - 1; i >= 0; i--) {
            System.out.print(digit[i]);
        }
    }
}

