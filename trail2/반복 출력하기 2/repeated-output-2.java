import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        printHW(N);
    }

    public static void printHW(int N) {
        if(N == 0) return;

        printHW(N - 1);

        System.out.println("HelloWorld");

        return;
    }
}