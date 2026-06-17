import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] checked = new int[201][201];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) + 100;
            int y1 = Integer.parseInt(st.nextToken()) + 100;
            int x2 = Integer.parseInt(st.nextToken()) + 100;
            int y2 = Integer.parseInt(st.nextToken()) + 100;

            for(int x = x1; x < x2; x++) {
                for(int y = y1; y < y2; y++) {
                    if(i%2 == 0) checked[x][y] = 1;
                    else checked[x][y] = 2;
                }
            }
        }
            
        int area = 0;
        for(int x = 0; x < 201; x++) {
            for(int y = 0; y < 201; y++) {
                if(checked[x][y] == 2) area++;
            }
        }
        System.out.print(area);
    }
}