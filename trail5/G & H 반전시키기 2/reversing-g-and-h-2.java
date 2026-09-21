import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static char[] a, b;

    public static void change(int idx) {
        while(idx >= 0) {
            if(a[idx] == 'G') a[idx] = 'H';
            else a[idx] = 'G';
            idx--;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();

        int ans = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(a[i] != b[i]) {
                change(i);
                ans++;
            }
        }
        System.out.print(ans);
    }
}