import java.util.*;
import java.io.*;

class Node {
    int num;
    Node prev, next;

    public Node(int num) {
        this.num = num;
        prev = next = null;
    }
}

public class Main {
    public static void connect(Node s, Node e) {
        if(s != null) s.next = e;
        if(e != null) e.prev = s;
    }

    public static void pop(Node cur) {
        connect(cur.prev, cur.next);
        cur.prev = cur.next = null;
    }

    public static void insertPrev(Node u, Node cur) {
        Node pU = u.prev;
        connect(cur, u);
        connect(pU, cur);
    }

    public static void popRange(Node a, Node b) {
        connect(a.prev, b.next);
        a.prev = b.next = null;
    }

    public static void insertRangePrev(Node a, Node b, Node c) {
        connect(c.prev, a);
        connect(b, c);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[n + 1];

        Node[] heads = new Node[m + 1];

        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int peopleCnt = Integer.parseInt(st.nextToken());

            Node last = null;
            for(int j = 1; j <= peopleCnt; j++) {
                int num = Integer.parseInt(st.nextToken());
                Node cur = new Node(num);
                nodes[num] = cur;
                if(j == 1) heads[i] = cur;
                else {
                    connect(last, cur);
                }
                last = cur;
            }
        }

        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            if(command == 1) {
                int b = Integer.parseInt(st.nextToken());

                for(int j = 1; j <= m; j++) {
                    if(nodes[a] == heads[j]) {
                        if(nodes[a].next == null) heads[j] = null;
                        else heads[j] = nodes[a].next;
                    }
                }

                for(int j = 1; j <= m; j++) {
                    if(nodes[b] == heads[j]) {
                        heads[j] = nodes[a];
                    }
                }
                
                pop(nodes[a]);
                insertPrev(nodes[b], nodes[a]);
            }
            else if(command == 2) {
                for(int j = 1; j <= m; j++) {
                    if(nodes[a] == heads[j]) {
                        if(nodes[a].next != null) heads[j] = nodes[a].next;
                        else heads[j] = null;
                    }
                }
                pop(nodes[a]);
            }
            else if(command == 3) {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                for(int j = 1; j <= m; j++) {
                    if(nodes[a] == heads[j]) {
                        if(nodes[b].next == null) heads[j] = null;
                        else heads[j] = nodes[b].next;
                    }
                }
                for(int j = 1; j <= m; j++) {
                    if(nodes[c] == heads[j]) {
                        heads[j] = nodes[a];
                    }
                }
                popRange(nodes[a], nodes[b]);
                insertRangePrev(nodes[a], nodes[b], nodes[c]);
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= m; i++) {
            Node start = heads[i];
            if(start == null) sb.append("-1");
            else {
                while(start != null) {
                    sb.append(start.num).append(" ");
                    start = start.next;
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}

// 1
// 2 3 