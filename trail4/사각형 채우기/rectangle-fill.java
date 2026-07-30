import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] method = new int[1001];

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        method[1] = 1;
        method[2] = 2;
        method[3] = 3;

        for(int i = 3; i <= n; i++) {
            method[i] = (method[i - 1] + method[i - 2]) % 10007;
        }

        System.out.println(method[n]);
    }
}