import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] s = new int[100];
        int[] n = new int[100];
        int sCnt = 0;
        int nCnt = 0;

        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            if(ch == 'S') s[sCnt++] = num;
            else n[nCnt++] = num;
        }

        int ans = 0;
        for(int i = a; i <= b; i++) {
            int d1 = Integer.MAX_VALUE;
            int d2 = Integer.MAX_VALUE;

            for(int j = 0; j < sCnt; j++) {
                d1 = Math.min(d1, Math.abs(s[j] - i));
            }

            for(int j = 0; j < nCnt; j++) {
                d2 = Math.min(d2, Math.abs(n[j] - i));
            }
            if(d1 <= d2) ans++;
        }
        System.out.print(ans);
    }
}