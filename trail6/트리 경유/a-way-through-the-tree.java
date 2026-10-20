import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < q; i++) {
            int target = Integer.parseInt(br.readLine());
            
            int current = target;
            int blockedNode = 0;

            while(current >= 1) {
                if(visited[current]) {
                    blockedNode = current;
                }

                current /= 2;
            }

            if(blockedNode == 0) {
                visited[target] = true;
            }

            sb.append(blockedNode).append("\n");
        }
        System.out.print(sb);
    }
}