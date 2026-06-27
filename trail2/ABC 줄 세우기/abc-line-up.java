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
            arr[i] = st.nextToken().charAt(0) - 'A';
        }

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == i) continue;

            int idx = 0;
            for(int j = i + 1; j < n; j++) {
                if(arr[j] == i) {
                    idx = j;
                    break;
                }
            }

            for(int j = idx; j > i; j--) {
                arr[j] = arr[j - 1];
            }
            arr[i] = i;

            cnt += idx - i;
        }
        System.out.print(cnt);
    }
}