import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] a = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            int money = b;
            int[] disc = a.clone();
            disc[i] = disc[i]/2;
            Arrays.sort(disc);

            for(int j = 0; j < n; j++) {
                if(money - disc[j] < 0) break;
                else {
                    money -= disc[j];
                    cnt++;
                }
            }
            max = Math.max(cnt, max);
        }

        System.out.print(max);
    }
}

