import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[15];
        for(int i = 0; i < 15; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // a, b, c, 
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];

        int d = arr[14] - a - b - c;

        System.out.print(a + " " + b + " " + c + " " + d);
    }
}