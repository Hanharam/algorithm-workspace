import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[2*n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2*n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;

        Arrays.sort(arr);
        for(int i = 0; i < n; i++) {
            min = Math.min(min, arr[i + n] - arr[i]);
        }

        System.out.print(min);
    }
}