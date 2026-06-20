import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[] a = br.readLine().toCharArray();

        int cnt = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    if(a[i] == 'C' && a[j] == 'O' && a[k] == 'W') cnt++;
                }
            }
        }
        System.out.print(cnt);

    }
}