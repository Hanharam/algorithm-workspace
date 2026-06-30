import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int c1, d1, c2, d2;
        if(x1 < a1) c1 = x1;
        else c1 = a1;

        if(y1 < b1) d1 = y1;
        else d1 = b1;

        if(x2 > a2) c2 = x2;
        else c2 = a2;

        if(y2 > b2) d2 = y2;
        else d2 = b2;

        int width = (c2 - c1) * (d2 - d1);

        System.out.print(width);
    }
}