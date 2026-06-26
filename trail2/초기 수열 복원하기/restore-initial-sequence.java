import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n -1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++) {
            int x = i;
            boolean[] used = new boolean[n + 1];
            int[] correct = new int[n];
            boolean isPossible = true;
            correct[0] = x;
            used[x] = true;
            
            for(int j = 0; j < n - 1; j++) {
                x = arr[j] - x;
                if(x < 1 || x > n || used[x]) {
                    isPossible = false;
                    break;
                }

                used[x] = true;
                correct[j + 1] = x;
            }

            if(isPossible) {
                for(int k = 0; k < n; k++) {
                    System.out.print(correct[k] + " ");
                }
                break;
            }
        }

    }
}

