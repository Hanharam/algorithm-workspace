import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dayOfMonth = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        String targetDay = br.readLine();

        int start = 0;
        for(int i = 1; i < m1; i++) {
            start += dayOfMonth[i];
        }
        start += d1;

        int end = 0;
        for(int i = 1; i < m2; i++) {
            end += dayOfMonth[i];
        }
         end += d2;

        int totalDays = end - start + 1;

        int baseCount = totalDays / 7;
        int remainder = totalDays % 7;

        String[] weeks = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int targetIdx = 0;
        for (int i = 0; i < 7; i++) {
            if (weeks[i].equals(targetDay)) {
                targetIdx = i;
                break;
            }
        }

        int bonus = 0;
        
        if (remainder > targetIdx) {
            bonus = 1;
        }

        System.out.println(baseCount + bonus);
    }
}