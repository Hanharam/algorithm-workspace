import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        String n = br.readLine();
        int[] digit = new int[20];

        for(int i = 0; i < n.length(); i++) {
            digit[i] = n.charAt(i) - '0';
        }

        int dec = 0;
        for(int i = 0; i < n.length(); i++) {
            dec = dec * a + digit[i];
        }

        int cnt = 0;
        while(true) {
            if(dec < b) {
                digit[cnt++] = dec;
                break;
            }

            digit[cnt++] = dec % b;
            dec = dec / b;
        }

        for(int i = cnt - 1; i >= 0; i--) {
            System.out.print(digit[i]);
        }

    }
}