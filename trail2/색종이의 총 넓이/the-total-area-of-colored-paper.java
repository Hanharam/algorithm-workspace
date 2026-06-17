import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX = 200;
    public static final int OFFSET = 100;

    public static void main(String[] args) throws IOException{
        // Please write your code here.
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] checked = new int[MAX + 1][MAX + 1];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            x1 += OFFSET;
            y1 += OFFSET;

            for(int x = x1; x < x1 + 8; x++) {
                for(int y = y1; y < y1 + 8; y++) {
                    checked[x][y]++;
                }
            }
        }
        int area = 0;
        for(int x = 0; x < MAX + 1; x++) {
            for(int y = 0; y < MAX + 1; y++) {
                if(checked[x][y] >= 1) area++;
            }
        }

        System.out.print(area);
    }
}