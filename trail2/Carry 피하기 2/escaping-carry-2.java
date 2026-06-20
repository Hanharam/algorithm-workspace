import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] a = new int[20];

    public static int isCarry(int x, int y, int z) {
        int tx = a[x];
        int ty = a[y];
            int tz = a[z];

        while(tx > 0 || ty > 0 || tz > 0) {
            int sum = (tx % 10) + (ty % 10) + (tz % 10);
            
            if(sum >= 10) {
                return -1;
            }
            tx /= 10;
            ty /= 10;
            tz /= 10;
        }
        return a[x] + a[y] + a[z];
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    max = Math.max(isCarry(i, j, k), max);
                }
            }
        }
        System.out.print(max);
    }
}