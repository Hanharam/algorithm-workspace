import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());

            int left = 1, right = n;
            int ans = -1;
            while(left <= right) {
                int mid = (left + right) / 2;

                if(arr[mid] == num) {
                    ans = mid;
                    break;
                }

                if(arr[mid] < num) left = mid + 1;
                else if(arr[mid] > num) right = mid - 1;
            }
            sb.append(ans + "\n");
        }

        System.out.print(sb);
    }
}