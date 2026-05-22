import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] num = new int[2 * n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 2 * n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int curNum = num[i] + num[(2 * n - 1) - i];
            if(curNum > max) max = curNum;
        }

        System.out.print(max);
    }
}