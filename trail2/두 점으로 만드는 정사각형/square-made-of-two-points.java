import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] x1 = new int[2];
        int[] y1 = new int[2];
        int[] x2 = new int[2];
        int[] y2 = new int[2];

        for(int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1[i] = Integer.parseInt(st.nextToken());
            y1[i] = Integer.parseInt(st.nextToken());
            x2[i] = Integer.parseInt(st.nextToken());
            y2[i] = Integer.parseInt(st.nextToken());
        }

        int a1 = Math.min(x1[0], x1[1]);
        int b1 = Math.min(y1[0], y1[1]);
        int a2 = Math.max(x2[0], x2[1]);
        int b2 = Math.max(y2[0], y2[1]);

        int length = Math.max(a2 - a1, b2 - b1);

        System.out.print(length * length);
    }
}