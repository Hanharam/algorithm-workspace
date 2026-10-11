import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static boolean[][] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new boolean[n + 1][n + 1];

        for(int i = 1; i <= n; i++) dist[i][i] = true;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dist[a][b] = true;
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(dist[i][k] && dist[k][j]) {
                        dist[i][j] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++) {
            int cnt = 0;
            for(int j = 1; j <= n; j++) {
                if(dist[i][j] || dist[j][i]) cnt++;
            }
            sb.append(n - cnt).append("\n");
        }
        
        System.out.print(sb);
    }
}