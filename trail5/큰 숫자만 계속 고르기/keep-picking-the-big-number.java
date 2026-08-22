import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            pq.add(-Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < m; i++) {
            pq.add(pq.poll() + 1);
        }

        System.out.print(-pq.peek());
    }
}