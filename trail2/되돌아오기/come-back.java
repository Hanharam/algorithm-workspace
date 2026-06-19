import java.io.*;
import java.util.*;

public class Main {
    public static int toDir(char dir) {
        if(dir == 'W') return 0;
        else if(dir == 'S') return 1;
        else if(dir == 'N') return 2;
        else return 3;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = new int[]{-1, 0, 0, 1}; // W, S, N, E
        int[] dy = new int[]{0, -1, 1, 0};

        int[] posA = new int[1001];
        int[] posB = new int[1001];

        int n = Integer.parseInt(br.readLine());

        int x = 0;
        int y = 0;
        int dist = 1;
        boolean isBack = false;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dir = toDir(st.nextToken().charAt(0));
            int d = Integer.parseInt(st.nextToken());

            for(int j = 0; j < d; j++) {
                posA[dist] = posA[dist - 1] + dx[dir];
                posB[dist] = posB[dist - 1] + dy[dir];
                dist++;
            }
        }

        for(int i = 1; i < dist; i++) {
            if(posA[i] == 0 && posB[i] == 0) {
                System.out.print(i);
                isBack = true;
                break;
            }
        }
        
        if(!isBack) System.out.print(-1);
    }
}