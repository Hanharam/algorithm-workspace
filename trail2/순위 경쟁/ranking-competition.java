import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int top = 0; // 0 -abc | 1 - ab | 2 - bc | 3 - ac | 4 - a | 5 - b | 6 - c

        int a = 0;
        int b = 0;
        int c = 0;

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            if(ch == 'A') a += num;
            else if(ch == 'B') b += num;
            else if(ch == 'C') c += num;

            if(a == b && b == c && top != 0) {cnt++; top = 0;}
            else if(a == b && a > c && top != 1) {cnt++; top = 1;}
            else if(b == c && b > a && top != 2) {cnt++; top = 2;}
            else if(a == c && a > b && top != 3) {cnt++; top = 3;}
            else if(a > b && a > c && top != 4) {cnt++; top = 4;}
            else if(b > a && b > c && top != 5) {cnt++; top = 5;}
            else if(c > a && c > b && top != 6) {cnt++; top = 6;}
        }
        System.out.print(cnt);
    }
}