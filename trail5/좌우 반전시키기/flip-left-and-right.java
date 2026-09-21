import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for(int i = 1; i < n; i++) {
            if(arr[i - 1] == 0) {
                ans++;

                arr[i - 1] = 1;
                arr[i] ^= 1;

                if(i + 1 < n) arr[i + 1] ^= 1;
            }
        }

        if(arr[n - 1] == 0) ans = -1;

        System.out.print(ans);
    }
}