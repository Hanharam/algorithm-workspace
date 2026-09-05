import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] first = new int[7];
        Arrays.fill(first, -1);

        first[0] = 0;

        long prefix = 0;
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            prefix += Long.parseLong(br.readLine());

            int remainder = (int) (prefix % 7);

            if(first[remainder] == -1) first[remainder] = i;
            else ans = Math.max(ans, i - first[remainder]);
        }
        System.out.print(ans);
    }
}