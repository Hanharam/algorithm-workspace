import java.io.*;
import java.util.*;

public class Main {

    public static boolean inRange(int x, int y, int n) {
        return (x >= 1 && x < n + 1 && y >= 1 && y < n + 1);
    }

    public static int getdir(char dir) {
        if(dir == 'U') return 2;
        else if(dir == 'D') return 1;
        else if(dir == 'R') return 0;
        else return 3;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dx = new int[]{0, 1, -1, 0};
        int[] dy = new int[]{1, 0, 0, -1};

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n+1][n+1];

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = getdir(st.nextToken().charAt(0));

        for(int i = 0; i < t; i++) {
            int nx = r + dx[d];
            int ny = c + dy[d];

            if(inRange(nx, ny, n)) {
                r = nx;
                c = ny;
            }
            else {
                d = 3 - d; 
            }
        }

        System.out.print(r + " " + c);
    }
}