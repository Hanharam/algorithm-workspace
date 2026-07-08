import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int ans = 0;

        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int x = i;
                int y = j;
                int maxVal = 0;

                for(int k = 0; k <= 2*(n - 1); k++) {
                    int cnt = 0;
                    for(int l = 0; l < n; l++) {
                        for(int o = 0; o < n; o++) {
                            if((Math.abs(x - l) + Math.abs(y - o)) <= k) {
                                if(arr[l][o] == 1) cnt++;
                            }
                        }
                    }
                    int cost = (k*k) + (k+1)*(k+1);
                    if(cnt * m >= cost) ans = Math.max(ans, cnt);
                }
            }
        }
        System.out.print(ans);
    }
}