import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int x = 0;
        int y = 0;

        int[] dx = new int[]{-1, 0, 0, 1};
        int[] dy = new int[]{0, -1, 1, 0};

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char dir = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            for(int j = 0; j < num; j++) {
            if(dir == 'W') {
                x += dx[0];
                y += dy[0];
            }
            else if(dir == 'S') {
                x += dx[1];
                y += dy[1];
            }
            else if(dir == 'N') {
                x += dx[2];
                y += dy[2];
            }
            else if(dir == 'E') {
                x += dx[3];
                y += dy[3];
            }
            }
        }

        System.out.print(x + " " + y);
    }
}