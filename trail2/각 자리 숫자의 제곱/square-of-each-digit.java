import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.print(sum(n));
    }

    public static int sum(int n) {
        if(n < 10) return n*n;

        return sum(n/10) + (n % 10)*(n % 10);
    }
}