import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        for(int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            nums[i] = a;
        }

        int cnt = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            if(i == 0 || nums[i]*nums[i - 1] > 0) cnt++;
            else cnt = 1;

            max = Math.max(max, cnt);
        }

        System.out.print(max);
    }
}