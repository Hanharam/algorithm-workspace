import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        int[][] dist = new int[n + 1][n + 1];

        StringTokenizer st;
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
                if(i == j) dist[i][j] = 1;
            }
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(dist[i][k] == 1 && dist[k][j] == 1) dist[i][j] = 1;
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }

    }
}