import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        int sum = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        int avg = sum / n;


        int cost = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] > avg) cost += arr[i] - avg;
        }

        System.out.print(cost);
    }
}