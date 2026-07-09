import java.io.*;
import java.util.*;

public class Main {
    public static int n;

    public static boolean inRange(int x, int y) {
            return x >= 0 && x < n && y >= 0 && y < n;
    }


    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        int[] dx = {-1, -1, 1, 1}; // 우상, 좌상, 좌하, 우하
        int[] dy = {1, -1, -1, 1};

        StringTokenizer st;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                for(int k = 1; k < n; k++) { // 우상 좌하
                    for(int l = 1; l < n; l++) { // 좌상, 우하

                        int p1X = i - k, p1Y = j + k;
                        int p2X = i - k - l, p2Y = j + k - l;
                        int p3X = i - l, p3Y = j - l;
                        
                        if (!inRange(p1X, p1Y) || !inRange(p2X, p2Y) || !inRange(p3X, p3Y)) {
                            continue; 
                        }

                        int sum = 0;
                        int x = i;
                        int y = j;

                        for(int q = 0; q < k; q++) {
                            x = x + dx[0];
                            y = y + dy[0];

                            sum += arr[x][y];
                        }

                        for(int w = 0; w < l; w++) {
                            x = x + dx[1];
                            y = y + dy[1];
                            sum += arr[x][y];
                        }
                        
                        for(int q = 0; q < k; q++) {
                            x = x + dx[2];
                            y = y + dy[2];
                            sum += arr[x][y];
                        }

                        for(int w = 0; w < l; w++) {
                            x = x + dx[3];
                            y = y + dy[3];
                            sum += arr[x][y];
                        }
                        
                        ans = Math.max(ans, sum);
                    }
                }

            }
        }
        System.out.print(ans);
    }
}