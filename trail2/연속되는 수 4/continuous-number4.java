import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }


        int cnt = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            if(i == 0 || arr[i] > arr[i-1]) cnt++;
            else cnt = 1;

            max = Math.max(max, cnt);
        }

        System.out.print(max);
    }
}