import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[7];

        for(int i = 0; i < 7; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int a;
        int b;
        int c;

        Arrays.sort(arr); // ?, ?, ?, a+b, a+c, b+c, a+b+c

        a = arr[0];
        b = arr[1];
        c = arr[6] - a - b;

        System.out.print(a + " " + b + " " + c);
    }
}