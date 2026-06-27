import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[] arr = br.readLine().toCharArray();

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(arr[i] == '1') continue;

            arr[i] = '1';
            int lastIdx = -1;
            int dist = Integer.MAX_VALUE;

            for(int j = 0; j < n; j++) {
                if(arr[j] == '1') {
                    if(lastIdx != -1) {
                        dist = Math.min(j - lastIdx, dist);
                    }
                    lastIdx = j;
                }
            }
            max = Math.max(max, dist);
            arr[i] = '0';
        }
        System.out.print(max);
    }
}