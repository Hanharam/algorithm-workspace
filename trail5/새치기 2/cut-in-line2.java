import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 100000;
    static final int MAX_M = 10;

    static class Node {
        String name;
        Node prev, next;

        Node(String name) {
            this.name = name;
            prev = next = null;
        }
    }

    static Node[] nodes = new Node[MAX_N + 1];
    static Node[] head = new Node[MAX_M + 1];
    static Node[] tail = new Node[MAX_M + 1];
    static int[] lineNum = new int[MAX_N + 1];
    static HashMap<String, Integer> personId = new HashMap<>();

    static StringBuilder sb = new StringBuilder();

    static void connect(Node s, Node e) {
        if(s != null) s.next = e;
        if(e != null) e.prev = s;
    }

    static void pop(Node i) {
        int l = lineNum[personId.get(i.name)];

        if(l == 0) return;

        if(head[l] == i) head[l] = head[l].next;
        if(tail[l] == i) tail[l] = tail[l].prev;

        connect(i.prev, i.next);
        
        lineNum[personId.get(i.name)] = 0;
        i.next = i.prev = null;
    }

    static void insertFront(Node a, Node b) {
        int lineNumB = lineNum[personId.get(b.name)];
        if(head[lineNumB] == b) head[lineNumB] = a;
        pop(a);

        connect(b.prev, a);
        connect(a, b);

        lineNum[personId.get(a.name)] = lineNumB;
    }

    static void popRangeAndInsertPrev(Node a, Node b, Node c) {
        int lineNumA = lineNum[personId.get(a.name)];
        int lineNumC = lineNum[personId.get(c.name)];

        if(head[lineNumA] == a) head[lineNumA] = b.next;
        if(tail[lineNumA] == b) head[lineNumA] = a.prev;

        connect(a.prev, b.next);

        if(head[lineNumC] == c) {
            connect(b, c);
            head[lineNumC] = a;
        } else {
            connect(c.prev, a);
            connect(b, c);
        }

        Node cur = a;
        while(cur != b) {
            lineNum[personId.get(cur.name)] = lineNumC;
            cur = cur.next;
        }
        lineNum[personId.get(cur.name)] = lineNumC;
    }

    static void printLine(int l) {
        Node cur = head[l];

        if(cur == null) {
            sb.append("-1").append("\n");
            return;
        }

        while(cur != null) {
            sb.append(cur.name).append(" ");
            cur = cur.next;
        }
        sb.append("\n");
        return;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int personNum = 1;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= m; i++) {
            for(int j = 0; j < n / m; j++) {
                String t = st.nextToken();
                personId.put(t, personNum);
                lineNum[personNum] = i;

                if(j == 0) {
                    tail[i] = head[i] = nodes[personNum] = new Node(t);
                } else {
                    nodes[personNum] = new Node(t);
                    connect(tail[i], nodes[personNum]);
                    tail[i] = nodes[personNum];
                }

                personNum++;
            }
        }

        while(q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int option = Integer.parseInt(st.nextToken());

            if(option == 1) {
                String x = st.nextToken();
                String y = st.nextToken();
                int a = personId.get(x), b = personId.get(y);
                insertFront(nodes[a], nodes[b]);
            } else if (option == 2) {
                String x = st.nextToken();
                int a = personId.get(x);
                pop(nodes[a]);
            } else if (option == 3) {
                String x = st.nextToken();
                String y = st.nextToken();
                String z = st.nextToken();
                int a = personId.get(x), b = personId.get(y), c = personId.get(z);
                popRangeAndInsertPrev(nodes[a], nodes[b], nodes[c]);
            }
        }
        
        for(int i = 1; i <= m; i++) printLine(i);

        System.out.print(sb);
    }
}