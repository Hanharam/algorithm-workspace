import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] months = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        int start = d1;
        for(int i = 1; i < m1; i++) {
            start += months[i];
        }

        int end = d2;
        for(int i = 1; i < m2; i++) {
            end += months[i];
        }

        int day = ((end - start) % 7 + 7) % 7;
        
        String[] dayOfWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Tue", "Sun"};

        System.out.print(dayOfWeek[day]);
    }
}