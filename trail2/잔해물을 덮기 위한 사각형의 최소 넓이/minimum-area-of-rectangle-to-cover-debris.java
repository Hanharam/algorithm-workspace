import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX = 2000;
    public static final int OFFSET = 1000;
    public static final int N = 2;
    
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] checked = new int[MAX + 1][MAX + 1];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            x1 += OFFSET;
            y1 += OFFSET;
            x2 += OFFSET;
            y2 += OFFSET;

            for(int x = x1; x < x2; x++) {
                for(int y = y1; y < y2; y++) {
                    checked[x][y] += i + 1;
                }
            }
        }

            int minX1 = Integer.MAX_VALUE;
            int minY1 = Integer.MAX_VALUE;
            int maxX2 = Integer.MIN_VALUE;
            int maxY2 = Integer.MIN_VALUE;

            for(int x = 0; x < MAX + 1; x++) {
                for(int y = 0; y < MAX + 1; y++) {
                    if(checked[x][y] == 1) {
                        if(minX1 > x) minX1 = x;
                        if(minY1 > y) minY1 = y;
                        if(maxX2 < x) maxX2 = x;
                        if(maxY2 < y) maxY2 = y;
                    }
                }
            }


            int area = 0;

            int[][] covered = new int[MAX + 1][MAX + 1];

            for(int x = minX1; x <= maxX2; x++) {
                for(int y = minY1; y <= maxY2; y++) {
                    covered[x][y]++;
                }
            }

            for(int x = 0; x < MAX + 1; x++) {
                for(int y = 0; y < MAX + 1; y++) {
                    if(covered[x][y] == 1) area++;
                }
            }

            System.out.print(area);
    }
}