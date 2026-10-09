import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, p, q;
    public static int[][] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        dist = new int[n + 1][n + 1];

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                dist[i][j] = (int) 1e9;

                if(i == j) dist[i][j] = 0;
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            dist[x][y] = Math.min(dist[x][y], d);
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        // for(int i = 1; i <= n; i++) {
        //     for(int j = 1; j <= n; j++) {
        //         System.out.print(dist[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        int count = 0;
        long sum = 0;
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int min = (int) 1e9;
            for(int j = 1; j <= p; j++) {
                min = Math.min(min, dist[a][j] + dist[j][b]);
            }

            if(min >= (int) 1e9) continue;

            sum += min;
            count++;
        }

        System.out.println(count);
        System.out.println(sum);
    }
}
