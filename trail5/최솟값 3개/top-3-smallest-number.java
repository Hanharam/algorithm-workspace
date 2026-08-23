import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            pq.add(Integer.parseInt(st.nextToken()));

            if(pq.size() > 3) {
                pq.poll();
            }

            if(i < 3) System.out.println(-1);
            else {
                long ans = 1;

                for(int x : pq) {
                    ans *= x;
                }
                System.out.println(ans);
            }
        }
    }
}