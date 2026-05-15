import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        printN1(N);
        System.out.println();
        printN2(N);
    }

    public static void printN1(int N) {
        if(N == 0) return;

        printN1(N - 1);
        System.out.print(N + " ");

        return;
    }

    public static void printN2(int N) {
        if(N == 0) return;

        System.out.print(N + " ");
        printN2(N - 1);

        return;
    }
}