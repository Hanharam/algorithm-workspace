import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] b = new int[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] cor1 = new boolean[4][4];

        cor1[1][2] = true;
        cor1[2][3] = true;
        cor1[3][1] = true;

        boolean[][] cor2 = new boolean[4][4];

        cor2[1][3] = true;
        cor2[3][2] = true;
        cor2[2][1] = true;

        int ans = Integer.MIN_VALUE;

        int g1 = 0;
        int g2 = 0;

        for(int i = 0; i < n; i++) {
            if(a[i] == b[i]) continue;

            int x = a[i];
            int y = b[i];

            if(cor1[x][y]) g1++;
            if(cor2[x][y]) g2++;
        }

        System.out.print(Math.max(g1, g2));
    }
}