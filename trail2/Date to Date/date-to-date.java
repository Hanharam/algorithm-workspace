import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num_of_days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        int end_date = 0;
        for(int i = 1; i < m2; i++) {
            end_date += num_of_days[i];
        }
        end_date += d2;

        int start_date = 0;
        for(int i = 1; i < m1; i++) {
            start_date += num_of_days[i];
        }
        start_date += d1;

        int days = end_date - start_date + 1;

        System.out.print(days);
    }
}