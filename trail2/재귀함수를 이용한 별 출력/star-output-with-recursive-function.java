import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        printStar(N);
    }

    public static void printStar(int N) {
        if(N == 0) return;

        printStar(N - 1);
        for(int i = 0; i < N; i++) {
            System.out.print("*");
        }
        System.out.println();

        return;
    }
}