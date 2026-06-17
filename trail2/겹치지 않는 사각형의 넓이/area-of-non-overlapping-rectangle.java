import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] grid = new int[2001][2001];

        for(int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            
            for(int j = x1; j < x2; j++) {
                for(int k = y1; k < y2; k++) {
                    if(i == 2) grid[j+1000][k+1000] += 2;
                    else grid[j+1000][k+1000]++;
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < 2001; i++) {
            for(int j = 0; j < 2001; j++) {
                if(grid[i][j] == 1) {
                    cnt++;
                }
            }
        }

        System.out.print(cnt);
    }
}