import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int v1, v2, e;
    public static int[][] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        dist = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                dist[i][j] = (int) 1e9;
                if(i == j) dist[i][j] = 0;
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = c;
            dist[b][a] = c;
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int minCost = dist[v1][e] + dist[v2][e];
        for(int k = 1; k <= n; k++) {
            minCost = Math.min(minCost, dist[v1][k] + dist[v2][k] + dist[k][e]);
        }
        
        if(minCost >= (int) 1e9) minCost = -1;
        System.out.print(minCost);
    }
}