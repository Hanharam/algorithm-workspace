import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = arr[n - 1] - arr[0];
        int answer = 0;

        while(left <= right) {
            int mid = (left + right) / 2;

            int count = 1;
            int last = arr[0];
            for(int i = 1; i < n; i++) {
                if(arr[i] - last >= mid) {
                    count++;
                    last = arr[i];
                }
            }

            if(count >= m) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.print(answer);
    }
}