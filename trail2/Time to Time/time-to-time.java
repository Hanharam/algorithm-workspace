import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hours = Integer.parseInt(st.nextToken());
        int mins = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int elapsedTime = 0;

        while(true) {
            if(hours == c && mins == d) {
                break;
            }

            elapsedTime++;
            mins++;

            if(mins == 60) {
                hours++;
                mins = 0;
            }
        }

        System.out.print(elapsedTime);
    }
}