import java.util.*;
import java.io.*;

class Node {
    int num;
    Node next, prev;

    public Node(int num) {
        this.num = num;
        Node next = prev = null;
    }
}

public class Main {

    public static void connect(Node s, Node e) {
        if(s != null) s.next = e;
        if(e != null) e.prev = s;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, Node> nodes = new HashMap<>();

        Node head = null;
        Node prev = null;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            Node cur = new Node(num);
            nodes.put(num, cur);

            if(i == 0) {
                head = cur;
            } else {
                connect(prev, cur);
            }

            prev = cur;
        }

        connect(prev, head);
        connect(prev, head);

        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());
            Node cur = nodes.get(num);

            sb.append(cur.next.num).append(" ").append(cur.prev.num).append("\n");
            
            connect(cur.prev, cur.next);
            cur.next = cur.prev = null;
        }
        System.out.print(sb);
    }
}