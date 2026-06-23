import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] p = new int[n];
        int[] s = new int[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            p[i] = Integer.parseInt(st.nextToken());
            s[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            int[] price = new int[n];
            int money = b;
            int cnt = 0;

            for(int j = 0; j < n; j++) {
                if(j == i) price[j] = p[j] / 2 + s[j];
                else price[j] = p[j] + s[j];
            }

            Arrays.sort(price);

            for(int k = 0; k < n; k++) {
                if(money - price[k] >= 0) {
                    money -= price[k];
                    cnt++;
                }
                else break;
            }
            max = Math.max(max, cnt);
        }
        System.out.print(max);
    }
}