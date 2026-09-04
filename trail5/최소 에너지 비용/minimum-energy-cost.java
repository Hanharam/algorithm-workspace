import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] move = new int[n - 1];
        int[] cost = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n - 1; i++) {
            move[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefixMin = new int[n];

        prefixMin[0] = cost[0];
        for(int i = 1; i < n; i++) {
            prefixMin[i] = Math.min(prefixMin[i - 1], cost[i]);
        }

        long ans = 0l;
        for(int i = 0; i < n - 1; i++) {
            ans += (long) move[i] * prefixMin[i];
        }
        System.out.print(ans);
    }
}