import java.io.*;
import java.util.*;

public class Main {
    public static int[][] arr;

    public static boolean isPositive(int x1, int y1, int x2, int y2) {
        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                if(arr[i][j] <= 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = -1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = i; k < n; k++) {
                    for(int l = j; l < m; l++) {
                        if(isPositive(i,j,k,l)) {
                            int size = (l - j + 1) * (k - i + 1);
                            ans = Math.max(ans, size);
                        }
                    }
                }
            }
        }

        System.out.print(ans);
    }
}