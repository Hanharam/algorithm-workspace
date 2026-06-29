import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int length = 1;
        for(int i = n - 2; i >= 0; i--) {
            if(arr[i] < arr[i + 1]) {
                length++;
            }
            else break;
        }
        System.out.print(n - length);

    }
}

