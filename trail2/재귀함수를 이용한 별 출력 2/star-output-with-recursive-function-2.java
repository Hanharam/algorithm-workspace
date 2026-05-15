import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        printStarSymmetry(n);
    }

    public static void printStarSymmetry(int n) {
        if(n == 0) return;

        for(int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println();

        printStarSymmetry(n - 1);

        for(int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}