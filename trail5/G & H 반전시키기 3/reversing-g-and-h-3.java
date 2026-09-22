import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static char[] a, b;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();

        int ans = 0;
        int curLength = 0;
        boolean diff = false;
        for(int i = 0; i < n; i++) {
            if(a[i] !=  b[i]) {
                curLength++;
                if(!diff) {
                    ans++;
                }
                diff = true;
            } else {
                diff = false;
                curLength = 0;
            }
            // System.out.printf("Idx = %d, curLength = %d\n", i + 1, curLength);

            if(curLength == 4) {
                curLength = 0;
                diff = false;
            }
        }
        System.out.print(ans);
    }
}