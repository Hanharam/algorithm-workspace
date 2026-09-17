import java.util.*;
import java.io.*;

public class Main {
    public static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            answer += a + b;
            pq.offer(a + b);
        }
        System.out.print(answer);
    }
}