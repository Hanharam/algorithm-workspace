import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String a = br.readLine();
        String b = br.readLine();

        int ans = 0;
        boolean mismatched = false;
        for(int i = 0; i < n; i++) {
            if(a.charAt(i) != b.charAt(i)) {
                if(!mismatched) {
                    ans++;
                    mismatched = true;
                }
            } else {
                mismatched = false;
            }
        }
        System.out.print(ans);
    }
}
