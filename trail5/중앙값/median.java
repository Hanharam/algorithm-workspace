import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> right = new PriorityQueue<>();
            
            int m = Integer.parseInt(br.readLine());
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++) {
                int num = Integer.parseInt(st.nextToken());

                if(left.isEmpty() || num <= left.peek()) {
                    left.add(num);
                }
                else right.add(num);



                if(left.size() > right.size() + 1) {
                    right.add(left.poll());
                }

                if(right.size() > left.size()) {
                    left.add(right.poll());
                }

                if(j % 2 == 1) {
                    System.out.print(left.peek() + " ");
                }
            }
            System.out.println();
        }
    }
}