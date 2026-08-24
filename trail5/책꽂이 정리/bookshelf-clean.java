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
    public static int n, k;
    public static Node[] head;
    public static Node[] tail;

    public static void connect(Node s, Node e) {
        if(s != null) s.next = e;
        if(e != null) e.prev = s;
    }

    public static void insertNext(Node u, Node cur, int j) {
        if(head[j] == null) {
            head[j] = cur;
            tail[j] = cur;
        }

        else {
            cur.prev = u;
            cur.next = u.next;

            connect(cur.prev, cur);
            connect(cur, cur.next);

            if(cur.next == null) tail[j] = cur;
        }
    }

    public static void deleteHead(int i) {
        Node removed = head[i];

        if(head[i].next == null) {
            head[i] = null;
            tail[i] = null;
        }
        else {
            head[i] = removed.next;
            head[i].prev = null;
        }
        removed.prev = null;
        removed.next = null;
    }

    public static void deleteTail(int i) {
        Node removed = tail[i];
        if(tail[i].prev == null) {
            head[i] = null;
            tail[i] = null;
        }
        else {
            tail[i] = removed.prev;
            tail[i].next = null;
        }
        removed.prev = null;
        removed.next = null;
    }

    public static void insertPrev(Node u, Node cur, int j) {
        if(head[j] == null) {
            cur.prev = null;
            cur.next = null;
            
            head[j] = cur;
            tail[j] = cur;
        }
        else {
            cur.next = u;
            cur.prev = u.prev;

            connect(cur, cur.next);
            connect(cur.prev, cur);

            head[j] = cur;
        }
    }

    public static void insertRangeNext(Node s, Node e, Node u, int i, int j) {
        if(u == null) {
            head[j] = s;
            tail[j] = e;
        }
        else {
            connect(tail[j], s);
            tail[j] = e;
        }
        head[i] = null;
        tail[i] = null;
    }

    public static void insertRangePrev(Node s, Node e, Node u, int i, int j) {
        if(u == null) {
            head[j] = s;
            tail[j] = e;
        }
        else {
            connect(e, head[j]);
            head[j] = s;
        }
        head[i] = null;
        tail[i] = null;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        head = new Node[k + 1];
        tail = new Node[k + 1];

        for(int i = 1; i <= n; i++) {
            insertNext(tail[1], new Node(i), 1);
        }

        int q = Integer.parseInt(br.readLine());

        for(int l = 0; l < q; l++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            if(head[i] == null) continue;

            if(command == 1) {
                Node cur = head[i];
                deleteHead(i);
                insertNext(tail[j], cur, j);
            }
            else if(command == 2) {
                Node cur = tail[i];
                deleteTail(i);
                insertPrev(head[j], cur, j);
            }
            else if(command == 3) {
                if(i == j) continue;
                insertRangePrev(head[i], tail[i], head[j], i, j);
            }
            else if(command == 4) {
                if(i == j) continue;
                insertRangeNext(head[i], tail[i], tail[j], i, j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= k; i++) {
            Node start = head[i];

            if(start == null) {
                sb.append("0\n");
                continue;
            }

            StringBuilder books = new StringBuilder();
            int count = 0;

            while(start != null) {
                count++;
                books.append(start.x).append(" ");
                start = start.next;
            }

            sb.append(count).append(" ")
            .append(books)
            .append("\n");
        }
        System.out.print(sb);
    }
}