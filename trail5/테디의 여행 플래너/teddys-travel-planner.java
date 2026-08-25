import java.util.*;
import java.io.*;

class Node {
    String nation;
    Node prev, next;

    public Node(String nation) {
        this.nation = nation;
        prev = null;
        next = null;
    }
}

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void connect(Node s, Node e) {
        if(s != null) s.next = e;
        if(e != null) e.prev = s;
    }

    public static void printLeftRight(Node head) {
        if(head.next == head.prev || head.next == null || head.prev == null) sb.append("-1\n");
        else {
            sb.append(head.prev.nation).append(" ").append(head.next.nation).append("\n");
        }
    }

    public static void insertNext(Node head, Node cur) {
        Node next = head.next;

        connect(head, cur);
        connect(cur, next);
    }

    public static void deleteNext(Node head) {
        if(head.next == null || head == head.next) return;

        connect(head, head.next.next);
    }

    public static void printTotal(Node head) {
        Node cur = head;

        do {
            System.out.print(cur.nation + " ");
            cur = cur.next;
        } while(cur != head);

        System.out.println();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[n];
        Node head = new Node("HI");

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nodes[i] = new Node(st.nextToken());

            if(i > 0) {
                connect(nodes[i - 1], nodes[i]);
            }
        }

        head = nodes[0];
        connect(nodes[n - 1], head);

        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());

            if(command == 1) {
                head = head.next;
            }
            else if(command == 2) {
                head = head.prev;
            }
            else if(command == 3) {
                deleteNext(head);
            }
            else if(command == 4) {
                Node cur = new Node(st.nextToken());
                insertNext(head, cur);
            }
            // printTotal(head);
            printLeftRight(head);
        }
        System.out.print(sb);
    }
}