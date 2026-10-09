import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] dist = new int[n + 1][n + 1];

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                dist[i][j] = (int) 1e9;
                if(i == j) dist[i][j] = 0;
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], c);
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        long totalCost = 0;
        int count = 0;
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            int minCost = (int) 1e9;
            for(int k = 1; k <= p; k++) {
                minCost = Math.min(minCost, dist[a][k] + dist[k][b]);
            }

            if(minCost == (int) 1e9) continue;

            totalCost += minCost;
            count++;
        }

        System.out.println(count);
        System.out.print(totalCost);
    }
}