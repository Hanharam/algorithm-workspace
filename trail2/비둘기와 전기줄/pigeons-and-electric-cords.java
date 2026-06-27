import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] p = new int[11];
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken()) + 1; // 1: 왼쪽, 2: 오른쪽

            if(p[num] == 0) p[num] = pos;
            else if(p[num] != pos) {
                cnt++;
                p[num] = pos;
            }
        }

        System.out.print(cnt);
    }
}