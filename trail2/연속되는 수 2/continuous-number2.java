import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            if(i == 0 || numbers[i] == numbers[i - 1]) cnt++;
            else {
                max = Math.max(max, cnt);
                cnt = 1;
            }
        }
        max = Math.max(max, cnt);
        System.out.print(max);
    }
}