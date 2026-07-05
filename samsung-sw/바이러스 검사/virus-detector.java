import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] store = new long[n];

        for(int i = 0; i < n; i++) {
            store[i] = Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(br.readLine());
        long leader = Integer.parseInt(st.nextToken());
        long member = Integer.parseInt(st.nextToken());

        long cnt = 0;
        for(int i = 0; i < n; i++) {
            if(store[i] > leader) {
                long remain = store[i] - leader;
                long memberCnt = (remain + member - 1) / member;
                cnt += memberCnt;
            }
            cnt++;
        }
        System.out.print(cnt);
    }
}