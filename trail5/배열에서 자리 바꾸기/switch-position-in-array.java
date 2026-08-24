import java.util.*;
import java.io.*;

class Node {
    int x;
    Node prev, next;

    public Node(int x) {
        this.x = x;
        prev = null;
        next = null;
    }
}

public class Main {
    public static void connect(Node s, Node e) {
        if (s != null) s.next = e;
        if (e != null) e.prev = s;
    }

    public static void change(Node a, Node b, Node c, Node d) {
        Node aPrev = a.prev;
        Node bNext = b.next;
        Node cPrev = c.prev;
        Node dNext = d.next;

        if(b.next == c) {
            connect(d, a);
            connect(b, dNext);

            connect(aPrev, c);
        }
        else if(d.next == a) {
            connect(cPrev, a);
            connect(b, c);

            connect(d, bNext);
        }
        else {
            connect(cPrev, a);
            connect(b, dNext);

            connect(aPrev, c);
            connect(d, bNext);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n + 1];
        for(int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);

            if(i > 1) {
                connect(nodes[i - 1], nodes[i]);
            }
        }

        int q = Integer.parseInt(br.readLine());
        for(int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            change(nodes[a], nodes[b], nodes[c], nodes[d]);
        }

        Node start = nodes[1];
        while(start.prev != null) {
            start = start.prev;
        }

        while(start != null) {
            sb.append(start.x).append(" ");
            start = start.next;
        }

        System.out.print(sb);
    }
}