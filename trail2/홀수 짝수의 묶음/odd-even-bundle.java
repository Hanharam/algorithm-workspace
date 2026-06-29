import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int odd = 0;
        int even = 0;

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num % 2 == 0) even++;
            else odd++;
        }

        while(odd > even) {
            odd -= 2;
            even++;
        }

        if(odd == even) {
            System.out.print(odd + even);
        }
        else if(even > odd) {
            System.out.print(2*odd + 1);
        }
    }
}