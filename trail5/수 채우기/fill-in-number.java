import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;

        if(n == 3 || n == 1) {
            count = -1;
        }
        else {
            count += n / 5;
            n = n % 5;

            if(n == 1) count += 2;
            else if(n == 3) count += 3;
            else count += n / 2;
        }
        System.out.print(count);
    }
}