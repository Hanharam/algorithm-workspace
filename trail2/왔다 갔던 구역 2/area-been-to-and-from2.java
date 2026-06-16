import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] block = new int[2001];
        
        int cur = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            if(st.nextToken().charAt(0) == 'L') {
                for(int j = cur - x; j < cur; j++) {
                    block[j + 1000]++;
                }
                cur = cur - x;
            }
            else {
                for(int j = cur; j < cur + x; j++) {
                    block[j + 1000]++;
                }
                cur = cur + x;
            }

        }

        int cnt = 0;
        for(int i = 0; i < 2001; i++) {
            if(block[i] >= 2) cnt++;
        }

        System.out.print(cnt);
    }
}

