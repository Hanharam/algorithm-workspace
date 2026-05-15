import java.io.*;
import java.util.*;

public class Main {

    static int total = 0;

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.print(cal(n));
    }

    public static int cal(int n){
        if(n == 1) return 0;

        if(n % 2 == 0) {
            return cal(n/2) + 1;
        }
        else {
            return cal(n/3) + 1;
        }
    }
}