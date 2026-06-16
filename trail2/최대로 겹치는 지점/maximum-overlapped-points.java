import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] block = new int[101];

        for(int i = 0; i < n; i++) {
            int a, b;
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            for(int j = a; j <= b; j++) {
                block[j]++;
            }
        }
        int max = 0;
        for(int i = 0; i < 101; i++) {
            if(max < block[i]) max = block[i];
        }

        System.out.print(max);
    }
}