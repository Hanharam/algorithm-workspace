import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] method = new long[1001];

        method[0] = 1;
        method[1] = 2;
        method[2] = 7;

        for(int i = 3; i <= n; i++) {
            method[i] = (3 * method[i - 1] + method[i - 2] - method[i - 3]) % 1000000007;
            if (method[i] < 0) {
                method[i] += 1000000007;
            }
        }
        System.out.print(method[n]);
    }
}

