import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[] arr = br.readLine().toCharArray();

        int lastIdx = 0;
        int dist = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 1; i < n; i++) {
            
            if(arr[i] == '1') {
                dist = Math.max(dist, i - lastIdx);
                min = Math.min(min, i - lastIdx);
                lastIdx = i;
            }
        }
        System.out.print(Math.min((dist/2), min));
    }
}