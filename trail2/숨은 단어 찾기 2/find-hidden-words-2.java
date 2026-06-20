import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] dx = new int[]{1, 0, -1, 0, 1, -1, 1, -1};
        int[] dy = new int[]{0, 1, 0, -1, 1, 1, -1, -1};
        char[] cor = {'L', 'E', 'E'};
        char[][] a = new char[n][m];

        for(int i  = 0; i < n; i++) {
            a[i] = br.readLine().toCharArray();
        }

        int sum = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int dir = 0; dir < 8; dir++) {
                    int nx = i;
                    int ny = j;
                    int cnt = 0;

                    for(int k = 0; k < 3; k++) {
                        if(inRange(nx, ny) && a[nx][ny] == cor[k]) {
                            cnt++;
                        }
                        nx += dx[dir];
                        ny += dy[dir];
                    }

                    if(cnt == 3) sum++;
                }
            }
        }

        System.out.print(sum);
        
    }
}