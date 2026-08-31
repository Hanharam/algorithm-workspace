import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] C = new int[n + 1];
        int[] W = new int[n + 2];

        char[] arr = (" " + br.readLine()).toCharArray();

        for(int i = 1; i <= n; i++) {
            C[i] = C[i - 1];

            if(arr[i] == 'C') C[i]++;
        }

        for(int i = n; i >= 1; i--) {
            W[i] = W[i + 1];

            if(arr[i] == 'W') W[i]++;
        }

        Long ans = 0l;
        for(int i = 1; i <= n; i++) {
            if(arr[i] == 'O') {
                ans += C[i] * W[i];
            }
        }

        System.out.print(ans);
    }
}