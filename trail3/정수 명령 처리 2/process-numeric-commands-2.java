import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        Queue<Integer> q = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String com = st.nextToken();

            if(com.equals("push")) q.add(Integer.parseInt(st.nextToken()));
            else if(com.equals("pop")) System.out.println(q.poll());
            else if(com.equals("size")) System.out.println(q.size());
            else if(com.equals("empty")) {
                if(q.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
            else if(com.equals("front")) System.out.println(q.peek());
        }
    }
}