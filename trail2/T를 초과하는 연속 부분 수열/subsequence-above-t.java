import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            if(arr[i] > T) cnt++;
            else cnt = 0;

            max = Math.max(cnt, max);
        }

        System.out.print(max);
    }
}