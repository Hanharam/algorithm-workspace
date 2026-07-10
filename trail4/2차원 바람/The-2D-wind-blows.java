import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] arr;

    public static void wind(int x1, int y1, int x2, int y2) {
        int temp;

        int x = x1;
        int y = y1;

        int upR = arr[x1][y2];
        int upL = arr[x1][y1];
        int downR = arr[x2][y2];
        int downL = arr[x2][y1];

        for(int j = y2; j > y1; j--) {
            arr[x1][j] = arr[x1][j - 1];
        }
        

        for(int i = x2; i > x1; i--) {
            arr[i][y2] = arr[i - 1][y2];
        }

        for(int j = y1; j < y2; j++) {
            arr[x2][j] = arr[x2][j + 1];
        }

        for(int i = x1; i < x2; i++) {
            arr[i][y1] = arr[i + 1][y1];
        }

        arr[x1 + 1][y2] = upR; 
        arr[x2][y2 - 1] = downR;
        arr[x2 - 1][y1] = downL;
    }

    public static void avg(int x1, int y1, int x2, int y2) {
        int[][] temp = new int[n][m];

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                int x = i;
                int y = j;

                int cnt = 1;
                int sum = arr[x][y];

                for(int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if(nx >= 0 && nx <= n - 1 && ny >= 0 && ny <= m - 1) {
                        cnt++;
                        sum += arr[nx][ny];
                    }
                }
                int avg = sum/cnt;
                temp[x][y] = avg;
            }
        }

        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                arr[i][j] = temp[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            wind(x1, y1, x2, y2);
            avg(x1, y1, x2, y2);
        }

        for(int i = 0; i < n; i++) {
            for(int num : arr[i]) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}