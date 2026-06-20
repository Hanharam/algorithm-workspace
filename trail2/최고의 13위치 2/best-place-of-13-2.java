import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] a = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - 2; j++) {
                for(int k = 0; k < n; k++) {
                    if(k == i) {
                        for(int l = j + 3; l < n - 2; l++) {
                            max = Math.max(max, a[i][j] + a[i][j+1] + a[i][j+2] + a[k][l] + a[k][l+1] + a[k][l+2]);
                        }
                    }
                    else {
                        for(int l = 0; l < n - 2; l++) {
                            max = Math.max(max, a[i][j] + a[i][j+1] + a[i][j+2] + a[k][l] + a[k][l+1] + a[k][l+2]);
                        }
                    }
                }
            }
        }
        System.out.print(max);
    }
}