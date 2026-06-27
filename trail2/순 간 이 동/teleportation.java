import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;

        int dist = Math.abs(a - b);

        min = Math.min(min, dist);

        dist = Math.abs(a - x) + Math.abs(y - b);

        min = Math.min(min, dist);

        dist = Math.abs(a - y) + Math.abs(x - b);

        min = Math.min(min, dist);

        System.out.print(min);
    }
}