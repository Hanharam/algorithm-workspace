import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> l = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();

            if(cmd.equals("push_front")) l.addFirst(Integer.parseInt(st.nextToken()));
            else if(cmd.equals("push_back")) l.addLast(Integer.parseInt(st.nextToken()));
            else if(cmd.equals("pop_front")) System.out.println(l.pollFirst());
            else if(cmd.equals("pop_back")) System.out.println(l.pollLast());
            else if(cmd.equals("size")) System.out.println(l.size());
            else if(cmd.equals("empty")) {
                if(l.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
            else if(cmd.equals("front")) System.out.println(l.peekFirst());
            else if(cmd.equals("back")) System.out.println(l.peekLast());
        }
    }
}