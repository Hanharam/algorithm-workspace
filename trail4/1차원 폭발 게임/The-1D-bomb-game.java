import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        boolean isTrue;
        int curLength = n;

        do {
            int streak = 1;
            int start = 0;
            isTrue = false;

            for(int j = 0; j < curLength - 1; j++) {
                if(arr[j] == arr[j + 1]) {
                    streak++;
                }
                else {
                    if(streak >= m) {
                        isTrue = true;
                        for(int k = start; k <= j; k++) {
                            arr[k] = 0;
                        }
                    }
                    streak = 1;
                    start = j + 1;
                }
            }

            if(streak >= m && curLength > 0) {
                    for(int k = start; k < curLength; k++) {
                        arr[k] = 0;
                    }
            } 

            int[] temp = new int[n];
            int idx = 0;
            for(int j = 0; j < curLength; j++) {
                if(arr[j] != 0) temp[idx++] = arr[j];
            }

            curLength = idx;

            for(int j = 0; j < curLength; j++) {
                arr[j] = temp[j];
            }

        } while(isTrue);

        System.out.println(curLength);

        for(int i = 0; i < curLength; i++) {
            System.out.println(arr[i]);
        }
    }
}