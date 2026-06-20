import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        int n = a.length;
        int cnt = 0;

        for(int i = 0; i < n; i++) {
                for(int k = i + 2; k < n - 1; k++) {
                        if(a[i] == '(' && a[i + 1] == '(' && a[k] == ')' && a[k + 1] == ')') {
                            cnt++;
                        }
                    }
            }
                System.out.print(cnt);

        }   
}