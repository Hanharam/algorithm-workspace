import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int t = 0;
        int leftDist = x;
        int v = 1;

        while(true) {
            leftDist -= v;
            t++;

            if(leftDist == 0)
                break;

            if(leftDist >= (v + 1) * (v + 2) / 2) v++;
            else if(leftDist >= v * (v + 1) / 2) {}
            else v--;
        }
        System.out.print(t);
    }
}