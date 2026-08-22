import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            pq.add(-Integer.parseInt(st.nextToken()));
        }

        while(pq.size() >= 2) {
            int x = -pq.poll();
            int y = -pq.poll();

            if(x != y) {
                pq.add(y - x);
            }
        }

        if(pq.isEmpty()) System.out.print(-1);
        else System.out.print(-pq.poll());
    }
}