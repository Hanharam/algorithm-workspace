import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();

        int[] digit = new int[number.length()];
        for(int i = 0; i < number.length(); i++) {
            digit[i] = number.charAt(i) - '0';
        }
        
        int num = 0;
        
        for(int i = 0; i < digit.length; i++) {
            num = num * 2 + digit[i];
        }

        System.out.println(num);
    }
}