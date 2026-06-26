import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        int max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        for(int i = max; i <= 10000; i++) {
            int cnt = 0;
            int sum = 0;

            for(int j = 0; j < n; j++) {
                sum += arr[j];

                if(sum > i) {
                    cnt++;
                    sum = arr[j];
                }
            }

            if(cnt < m) {
                System.out.print(i);
                break;
            }
        }
    }
}