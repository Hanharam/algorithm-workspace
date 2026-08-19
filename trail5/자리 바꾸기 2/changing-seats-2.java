import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        HashSet<Integer>[] visited = new HashSet[n + 1];

        int[] a = new int[k + 1];
        int[] b = new int[k + 1];
        int[] seat = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            seat[i] = i;
            visited[i] = new HashSet<>();
            visited[i].add(i);
        }

        for(int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < 3; i++) {

            for(int j = 1; j <= k; j++) {
                int x = a[j];
                int y = b[j];

                int personX = seat[x];
                int personY = seat[y];

                seat[x] = personY;
                seat[y] = personX;

                visited[personX].add(y);
                visited[personY].add(x);
            }
        }

        for(int i = 1; i <= n; i++) {
            System.out.println(visited[i].size());
        }

    }
}