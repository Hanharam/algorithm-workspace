import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int end_minutes = (a * 24 * 60) + (b * 60) + c;
        int start_minutes = (11 * 24 * 60) + (11 * 60) + 11;

        int diff = end_minutes - start_minutes;

        if(diff < 0) {
            System.out.print(-1);
        }
        else {
            System.out.print(diff);
        }        
    }
}