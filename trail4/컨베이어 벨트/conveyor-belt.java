import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < t; i++) {
            int temp1 = arr1[n - 1];
            int temp2 = arr2[n - 1];

            for(int j = n - 1; j > 0; j--) {
                arr1[j] = arr1[j - 1];
                arr2[j] = arr2[j - 1];
            }

            arr1[0] = temp2;
            arr2[0] = temp1;
        }

        for(int num : arr1) {
            System.out.print(num + " ");
        }
        System.out.println();
        for(int num : arr2) {
            System.out.print(num + " ");
        }
    }
}