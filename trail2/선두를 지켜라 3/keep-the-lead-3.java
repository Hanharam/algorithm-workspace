import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX = 1000000;
        
    public static int n, m;
    public static int[] top = new int[MAX + 1];
    public static int[] posA = new int[MAX + 1];
    public static int[] posB = new int[MAX + 1];

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int timeA = 1;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            for(int j = 0; j < t; j++) {
                posA[timeA] = posA[timeA - 1] + v;
                timeA++;
            }
        }

        int timeB = 1;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            for(int j = 0; j < t; j++) {
                posB[timeB] = posB[timeB - 1] + v;
                timeB++;
            }
        }

        for(int i = 1; i < Math.max(timeA, timeB); i++) {
            if(posA[i] > posB[i]) top[i] = 1;
            else if(posA[i] < posB[i]) top[i] = 2;
            else top[i] = 3;
        }

        int cnt = 0;
        for(int i = 1; i < Math.max(timeA, timeB); i++) {
            if(top[i] != top[i - 1]) cnt++;
        }

        System.out.print(cnt);
    }
}