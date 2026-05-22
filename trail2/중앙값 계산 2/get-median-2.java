import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];

        for(int i = 1; i < n + 1; i++) {
            nums[i - 1] = Integer.parseInt(st.nextToken());
            Arrays.sort(nums, 0, i);
            if(i%2 == 1) System.out.print(nums[i/2] + " ");
        }
    }
}