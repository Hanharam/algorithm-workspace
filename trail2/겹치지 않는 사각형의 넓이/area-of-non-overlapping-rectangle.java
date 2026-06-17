import java.io.*;
import java.util.*;

public class Main {
    public static final int N = 3;
    public static final int MAX_R = 2000;
    public static final int OFFSET = 1000;

    public static int[] x1 = new int[N];
    public static int[] y1 = new int[N];
    public static int[] x2 = new int[N];
    public static int[] y2 = new int[N];


    public static int[][] checked = new int[MAX_R + 1][MAX_R + 1];

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1[i] = Integer.parseInt(st.nextToken());
            y1[i] = Integer.parseInt(st.nextToken());
            x2[i] = Integer.parseInt(st.nextToken());
            y2[i] = Integer.parseInt(st.nextToken());

            x1[i] += OFFSET;
            y1[i] += OFFSET;
            x2[i] += OFFSET;
            y2[i] += OFFSET;

        }

        for(int i = 0; i < N; i++) {
            for(int x = x1[i]; x < x2[i]; x++) {
                for(int y = y1[i]; y < y2[i]; y++) {
                    checked[x][y] += i + 1;
                }
            }
        }

        int area = 0;

        for(int x = 0; x < MAX_R + 1; x++) {
            for(int y = 0; y < MAX_R + 1; y++) {
                if(checked[x][y] == 1 || checked[x][y] ==2) area++;
            }
        }

        System.out.print(area);
    }
}