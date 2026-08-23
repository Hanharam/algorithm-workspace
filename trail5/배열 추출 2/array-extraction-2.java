import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int x;

    public Node(int x) {
        this.x = x;
    }

    @Override
    public int compareTo(Node n) {
        if(Math.abs(x) != Math.abs(n.x)) return Math.abs(x) - Math.abs(n.x);
        else return x - n.x;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num != 0) {
                pq.add(new Node(num));
            }
            else {
                if(pq.isEmpty()) System.out.println(0);
                else {
                    System.out.println(pq.poll().x);
                }
            }
        }
    }
}