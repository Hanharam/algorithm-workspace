import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int cnt = 0;
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j <= n; j++) {
                int mean;
                int sum = 0;
                int num = 0;
                boolean isTrue = false;
                for(int k = i; k < j; k++) {
                    sum += a[k];
                    num++;
                }
                mean = sum/num;
                if(sum%num == 0) {
                for(int k = i; k < j; k++) {
                    if(a[k] == mean) {isTrue = true;}
                }
                if(isTrue) {cnt++;
                }
                }
            }
        }

        System.out.print(cnt);
    }
}