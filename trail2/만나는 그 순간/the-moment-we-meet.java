import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int[] a = new int[1000001];
        int[] b = new int[1000001];

        int cur = 1;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char dir = st.nextToken().charAt(0);
            int t = Integer.parseInt(st.nextToken());

            for(int j = 0; j < t; j++) {
                if(dir == 'R') a[cur] = a[cur - 1] + 1;
                else a[cur] = a[cur - 1] - 1;
                cur++;
            }
        }
        int timeA = cur - 1;

        cur = 1;

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            char dir = st.nextToken().charAt(0);
            int t = Integer.parseInt(st.nextToken());

            for(int j = 0; j < t; j++) {
                if(dir == 'R') b[cur] = b[cur - 1] + 1;
                else b[cur] = b[cur - 1] - 1;
                cur++;
            }
        }
        int timeB = cur - 1;

        boolean isTrue = false;

        for(int i = 1; i < Math.min(timeA, timeB); i++) {
            if(a[i] == b[i]) {
                System.out.print(i);
                isTrue = true;
                break;
            }
        }

        if(!isTrue) System.out.print(-1);
    }
}