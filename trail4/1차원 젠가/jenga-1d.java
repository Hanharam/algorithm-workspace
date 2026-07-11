import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        StringTokenizer st;

        int size = n;
        for(int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;

            int[] temp = new int[n];
            int endOfArr = 0;

            for(int j = s; j <= e; j++) {
                arr[j] = 0;
            }

            for(int j = 0; j < size; j++) {
                if(arr[j] != 0) {
                    temp[endOfArr++] = arr[j];
                }
            }

            for(int j = 0; j < endOfArr; j++) {
                arr[j] = temp[j];
            }

            size -= (e - s + 1);
        }

        System.out.println(size);
        for(int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }
}