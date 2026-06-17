import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] posA = new int[1000000 + 1];
        int[] posB = new int[1000000 + 1];

        int timeA = 1;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            for(int j = 0; j < t; j++) {
                posA[timeA] = posA[timeA - 1] + v;
                timeA++;
            }
        }

        int timeB = 1;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            for(int j = 0; j < t; j++) {
                posB[timeB] = posB[timeB - 1] + v;
                timeB++;
            }
        }

        int cnt = 0;
        int leader = 0;

        for(int i = 0; i < timeB; i++) {
            if(posA[i] > posB[i]) {
                if(leader == 0) leader = 1;
                else if(leader == 2) {
                    cnt++;
                    leader = 1;
                }
            }
            else if(posB[i] > posA[i]) {
                if(leader == 0) leader = 2;
                if(leader == 1) {
                    cnt++;
                    leader = 2;
                }
            }
        }

        System.out.print(cnt);
    }
}