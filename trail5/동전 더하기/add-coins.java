import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int idx = n;
        int answer = 0;
        while(k > 0) {
            idx--;
            if(arr[idx] > k) continue;
            
            answer += k / arr[idx];
            k = k % arr[idx];
        }
        System.out.print(answer);
    }  
}