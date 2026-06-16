import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] block = new int[201];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a, b;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            for(int j = a; j < b; j++) {
                block[j+100]++;
            }
        }
        int max = 0;
        for(int i = 0; i < 201; i++) {
            if(max < block[i]) max = block[i];
        }

        System.out.print(max);
    }
}