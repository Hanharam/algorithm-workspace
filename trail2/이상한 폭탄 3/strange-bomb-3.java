import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[1000001];

        for(int i = 0; i < n; i++) {
            boolean isExploded = false;

            for(int j = Math.max(0, i - k); j <= Math.min(i + k, n - 1); j++) {
                if(i != j && arr[i] == arr[j]) {
                    isExploded = true;
                    break;
                }
            }

            if(isExploded) {
                count[arr[i]]++;
            }
        }

        int maxNum = 0;
        int maxCount = 0;

        for(int i = 0; i < 1000000; i++) {
            if(count[i] > 0 && count[i] >= maxCount) {
                maxCount = count[i];
                maxNum = i;
            }
        }
        System.out.print(maxNum);
    }
}