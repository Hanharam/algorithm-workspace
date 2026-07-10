import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] arr = new int[3][n];

        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int j = 0; j < t; j++) {
            int temp1 = arr[0][n - 1];
            int temp2 = arr[1][n - 1];
            int temp3 = arr[2][n - 1];
            
            for(int i = n - 1; i > 0; i--) {

                arr[0][i] = arr[0][i - 1];
                arr[1][i] = arr[1][i - 1];
                arr[2][i] = arr[2][i - 1];

            }
            arr[0][0] = temp3;
            arr[1][0] = temp1;
            arr[2][0] = temp2;
        }

        for(int i = 0; i < 3; i++) {
            for(int num : arr[i]) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}