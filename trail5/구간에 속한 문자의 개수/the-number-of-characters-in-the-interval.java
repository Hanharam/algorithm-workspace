import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[][] arr = new char[n + 1][m + 1];

        int[][] a = new int[n + 1][m + 1];
        int[][] b = new int[n + 1][m + 1];
        int[][] c = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            arr[i] = (" " + br.readLine()).toCharArray();
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                a[i][j] = a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1];
                b[i][j] = b[i - 1][j] + b[i][j - 1] - b[i - 1][j - 1];
                c[i][j] = c[i - 1][j] + c[i][j - 1] - c[i - 1][j - 1];

                if(arr[i][j] == 'a') {
                    a[i][j] += 1;
                } else if(arr[i][j] == 'b') {
                    b[i][j] += 1;
                } else if(arr[i][j] == 'c') {
                    c[i][j] += 1;
                }
            }
        }

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int cntA = a[x2][y2] - a[x2][y1 - 1] - a[x1 - 1][y2] + a[x1 - 1][y1 - 1];
            int cntB = b[x2][y2] - b[x2][y1 - 1] - b[x1 - 1][y2] + b[x1 - 1][y1 - 1];
            int cntC = c[x2][y2] - c[x2][y1 - 1] - c[x1 - 1][y2] + c[x1 - 1][y1 - 1];

            sb.append(cntA).append(" ").append(cntB).append(" ").append(cntC).append("\n");
        }
        System.out.print(sb);
    }
}