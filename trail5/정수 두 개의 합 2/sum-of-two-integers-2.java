import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static int[] arr = new int[100001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, 1, n + 1);

        long ans = 0;

        int i = 1;
        int j = n;
        while(i < j) {
            
            if(arr[i] + arr[j] <= k) {
                ans += j - i;
                i++;
            }
            else j--;
        }

        System.out.print(ans);
    }
}