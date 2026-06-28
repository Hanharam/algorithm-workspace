import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] total = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            total[i] = num;
            cnt++;
        }

        Arrays.sort(total);

        int max1 = total[cnt - 1] * total[cnt - 2] * total[cnt - 3];
        int max2 = total[cnt - 1] * total[0] * total[1];
        
        System.out.print(Math.max(max1, max2));
    }
}