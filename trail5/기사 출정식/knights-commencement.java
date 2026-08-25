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

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, Node> nodes = new HashMap<>();

        Node head = new Node(999);
        Node prev = new Node(999);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            Node cur = new Node(num);

            nodes.put(num, cur);
            if(i > 0) {
                connect(prev, cur);
            }
            prev = cur;
            if(i == 0) head = cur;
        }
        connect(prev, head);

        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());
            Node cur = nodes.get(num);
            System.out.println(cur.next.num + " " + cur.prev.num);
            connect(cur.prev, cur.next);
            cur.next = cur.prev = null;
        }
    }
}