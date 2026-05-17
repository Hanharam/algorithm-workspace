import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        System.out.print(fib(n));
    }

    public static int fib(int n) {
        if(n == 1 || n == 2) return 1;

        return fib(n - 1) + fib(n - 2);
    }
}