import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        boolean isOverlap = true;

        if(b < c || d < a) isOverlap = false;

        int area;
        if(isOverlap) {
            int max = Math.max(b, d);
            int min = Math.min(a, c);
            
            area = max - min;
        }
        else {
            area = b - a + d - c;
        }

        System.out.print(area);
    }
}