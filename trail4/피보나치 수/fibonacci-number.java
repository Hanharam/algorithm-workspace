import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] memo = new int[46];

    public static int fibo(int n) {
        if(memo[n] != -1) {
            return memo[n];
        }
        if(n <= 2) return 1;
        
        else
            memo[n] = fibo(n - 1) + fibo(n - 2);

        return memo[n];
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Arrays.fill(memo, -1);

        System.out.print(fibo(n));
    }
}