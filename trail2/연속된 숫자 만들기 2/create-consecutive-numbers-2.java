import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[3];

        for(int i = 0; i < 3; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        boolean zero = true;
        for(int i = 0; i < 2; i++) {
            if(a[i + 1] - a[i] != 1) zero = false;
        }

        if(zero) {
            System.out.print(0);
            return;
        }
        

        boolean first = false;
        for(int i = 0; i < 2; i++) {
            if(a[i + 1] - a[i] == 2) first = true;
        }

        if(first) System.out.print(1);
        else System.out.print(2);
    }
}
