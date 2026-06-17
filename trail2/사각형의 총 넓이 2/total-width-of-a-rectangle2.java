import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] square = new int[201][201];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j = x1; j < x2; j++) {
                for(int k = y1; k < y2; k++) {
                    square[j+100][k+100] = 1;
                }
            }
        }

        int cnt = 0;
            for(int i = 0; i < 201; i++) {
                for(int j = 0; j < 201; j++) {
                    if(square[i][j] == 1) cnt++;
                }
            }

        System.out.print(cnt);
    }
}