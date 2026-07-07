import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        int ans = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            int cnt = 1;
            int maxCnt = 1;
            int x = i;
            int y = 1;

            for(int j = 0; j < n - 1; j++) {
                if(arr[x][y] == arr[x][y - 1]) {
                    cnt++;
                    maxCnt = Math.max(maxCnt, cnt);
                }
                else cnt = 1;
                y++;
            }

            if(maxCnt >= m) {
                ans++;
            }
        }

        for(int i = 0; i < n; i++) {
            int cnt = 1;
            int maxCnt = 1;
            int y = i;
            int x = 1;

            for(int j = 0; j < n - 1; j++) {
                if(arr[x][y] == arr[x - 1][y]) {
                    cnt++;
                    maxCnt = Math.max(maxCnt, cnt);
                }
                else cnt = 1;
                x++;
            }

            if(maxCnt >= m) {
                ans++;
            }
        }
        System.out.print(ans);
    }
}