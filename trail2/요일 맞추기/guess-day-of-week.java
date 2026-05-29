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
        switch(day) {
            case 0:
                System.out.print("Mon");
                break;
            case 1:
                System.out.print("Tue");
                break;
            case 2:
                System.out.print("Wed");
                break;
            case 3:
                System.out.print("Thu");
                break;
            case 4:
                System.out.print("Fri");
                break;
            case 5:
                System.out.print("Sat");
                break;
            case 6:
                System.out.print("Sun");
                break;
        }


    }
}