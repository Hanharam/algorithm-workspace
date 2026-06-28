import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int top = 0; // A, B : 0 || A : 1 || B : 2
        int a = 0;
        int b = 0;

        int cnt = 0;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());
            
            if(c == 'A') a += num;
            else b += num;

            if(a == b && top != 0) {
                top = 0;
                cnt++;
            } 
            else if(a > b && top != 1) {
                top = 1;
                cnt++;
            }
            else if(a < b && top != 2) {
                top = 2;
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}