import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String a = br.readLine();

        int ans = Integer.MAX_VALUE;

        for(int i = 1; i <= a.length() + 1; i++) {
            boolean isDuplicated = false;

            for(int j = 0; j <= n - i; j++) {
                String sub = a.substring(j, j + i);

                if(a.indexOf(sub, j + 1) != -1) {
                    isDuplicated = true;
                    break;
                }
            }

            if(!isDuplicated) {
                ans = Math.min(ans, i);
                break;
            }
        }
        System.out.print(ans);
    }
}