import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] x = new int[n];
        int[] y = new int[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        boolean isPossible = false;

        for(int i = 0; i <= 10; i++) {
            for(int j = 0; j <= 10; j++) {
                for(int k = 0; k <= 10; k++) {
                    boolean case1 = true;
                    boolean case2 = true;
                    boolean case3 = true;
                    boolean case4 = true;

                    for(int l = 0; l < n; l++) {
                        if(!(x[l] == i || x[l] == j || x[l] == k)) case1 = false;
                        if(!(x[l] == i || x[l] == j || y[l] == k)) case2 = false;
                        if(!(x[l] == i || y[l] == j || y[l] == k)) case3 = false;
                        if(!(y[l] == i || y[l] == j || y[l] == k)) case4 = false;
                    }

                    if(case1 || case2 || case3 || case4) {
                        isPossible = true;
                        break;
                    }
                }
                if(isPossible) break;
            }
            if(isPossible) break;
        }
        if(isPossible) System.out.print(1);
        else System.out.print(0);
    }
}