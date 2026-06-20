import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] distance = new int[n];

        for(int i = 0; i < n; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        int minDis = Integer.MAX_VALUE;
        int sumDis = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sumDis += distance[j] * Math.abs(i - j);
            }
            minDis = Math.min(minDis, sumDis);
            sumDis = 0;
        }
        System.out.print(minDis);
    }
}