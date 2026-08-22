import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("push")) {
                int a = Integer.parseInt(st.nextToken());
                pq.add(-a);
            }
            else if(command.equals("pop")) {
                System.out.println(-pq.poll());
            }
            else if(command.equals("size")) {
                System.out.println(pq.size());
            }
            else if(command.equals("empty")) {
                if(pq.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
            else if(command.equals("top")) {
                System.out.println(-pq.peek());
            }
        }
    }
}