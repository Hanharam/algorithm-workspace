import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.print(cal(n));
    }
    
    public static int cal(int n){
        if(n == 1) return 2;
        else if(n == 2) return 4;
        else {
            return (cal(n - 1) * cal(n - 2)) % 100;
        }
    }
}