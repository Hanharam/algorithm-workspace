import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] fire = new int[n + 1];
        int[] station = new int[m + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            fire[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= m; i++) {
            station[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(fire, 1, n + 1);
        Arrays.sort(station, 1, m + 1);

        int[] dist = new int[n + 1];

        int j = 1;
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            while(j < m && Math.abs(fire[i] - station[j]) >= Math.abs(fire[i] - station[j + 1])){
                j++;
            }

            int d = Math.abs(fire[i] - station[j]);
            ans = Math.max(ans, d);
        }

        System.out.print(ans);
    }
}