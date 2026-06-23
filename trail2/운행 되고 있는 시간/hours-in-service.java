import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] b = new int[n];


        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for(int i = 0; i < n; i++) {
            int[] time = new int[1000];

            for(int j = 0; j < n; j++) {
                // 한 명씩 제외
                if(j == i) continue;
                
                for(int k = a[j]; k < b[j]; k++) {
                    time[k]++;
                }
            }

            int cnt = 0;
            for(int j = 0; j < 1000; j++) {
                if(time[j] > 0) cnt++;
            }

            answer = Math.max(answer, cnt);
        }

        System.out.print(answer);
    }
}