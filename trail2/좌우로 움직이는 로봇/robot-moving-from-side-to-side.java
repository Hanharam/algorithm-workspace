import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX = 2000000;

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] posA = new int[MAX + 1];
        int[] posB = new int[MAX + 1];

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int timeA = 1;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);

            for(int j = 0; j < t; j++) {
                if(d == 'R') {
                    posA[timeA] = posA[timeA - 1] + 1;
                }
                else {
                    posA[timeA] = posA[timeA - 1] - 1;
                }
                timeA++;
            }
        }

        int timeB = 1;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);

            for(int j = 0; j < t; j++) {
                if(d == 'R') {
                    posB[timeB] = posB[timeB - 1] + 1;
                }
                else {
                    posB[timeB] = posB[timeB - 1] - 1;
                }
                timeB++;
            }
        }

        if(timeA > timeB) {
            for(int i = timeB; i < timeA; i++) {
                posB[i] = posB[i - 1];
            }
        }
        else {
            for(int i = timeA; i < timeB; i++) {
                posA[i] = posA[i - 1];
            }
        }

        boolean isSame = false;
        int cnt = -1;
        for(int i = 0; i < Math.max(timeA, timeB); i++) {
            if(posA[i] == posB[i] && !isSame) {
                cnt++;
                isSame = true;
            }
            else if(posA[i] != posB[i]) {
                isSame = false;
            }
        }

        System.out.print(cnt);
    }
}