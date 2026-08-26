import java.util.*;
import java.io.*;

class Node {
    String name;
    Node prev, next;

    public Node(String name) {
        this.name = name;
        prev = next = null;
    }
}

public class Main {
    public static int n, m, q;

    public static HashMap<String, Node> nodes = new HashMap<>();
    public static Node[] heads;
    public static Node[] tails;

    public static void connect(Node s, Node e) {
        if(s != null) s.next = e;
        if(e != null) e.prev = s;
    }

    public static void checkHeadTail(Node cur) {
        for(int i = 1; i <= m; i++) {
            if(heads[i] == cur) {
                if(cur.next == null) heads[i] = null;
                else {
                    heads[i] = cur.next;
                }
            }
            if(tails[i] == cur) {
                if(cur.prev == null) tails[i] = null;
                else {
                    tails[i] = cur.prev;
                }
            }
        }
    }

    public static void pop(Node cur) {
        connect(cur.prev, cur.next);
        cur.next = cur.prev = null;
    }

    public static void insertPrev(Node a, Node b) {
        if(a.next == b) return;

        checkHeadTail(a);
        
        for(int i = 1; i <= m; i++) {
            if(heads[i] == b) {
                heads[i] = a;
            }
        }

        pop(a);

        connect(b.prev, a);
        connect(a, b);
    }

    public static void insertRangePrev(Node a, Node b, Node c) {
        if(b.next == c) return;

        for(int i = 1; i <= m; i++) {
            if(heads[i] == a) {
                if(b.next != null) heads[i] = b.next;
                else heads[i] = null;
            }
        }
        for(int i = 1; i <= m; i++) {
            if(heads[i] == c) {
                heads[i] = a;
            }
        }

        Node prevA = a.prev;
        Node nextB = b.next;
        Node prevC = c.prev;
        // v  a s d f b | c e
        connect(prevA, nextB);
        connect(prevC, a);
        connect(b, c);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        heads = new Node[m + 1];
        tails = new Node[m + 1];

        int x = n / m;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            String name = st.nextToken();
            Node cur = new Node(name);
            nodes.put(name, cur);

            int index = (int) Math.ceil((double)i/x);

            int order = (i - 1) % x + 1; 

            if(order == 1) {
                heads[index] = cur;
                tails[index] = cur;
            } else {
                connect(tails[index], cur);
                tails[index] = cur;
            }
        }

        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            String a = st.nextToken();
            
            if(command == 1) {
                String b = st.nextToken();
                insertPrev(nodes.get(a), nodes.get(b));
            } else if(command == 2) {
                pop(nodes.get(a));
            } else if(command == 3) {
                String b = st.nextToken();
                String c = st.nextToken();
                insertRangePrev(nodes.get(a), nodes.get(b), nodes.get(c));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= m; i++) {
            Node start = heads[i];
            if(start == null) sb.append("-1\n");
            else {
                while(start != null) {
                    sb.append(start.name).append(" ");
                    start = start.next;
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}

// N = 4 은 사람들의 수, M = 2은 줄의 수

// X = N/M = 2

// i 번째 사람은 ceiling(i/X) 번 줄의 (i - 1) mod (X) + 1 번 째로 서있음

// 1 -> ceiling(1/2) == 1번 줄 || (1 - 1 == 0) mod (2) + 1 ->  1 번 째

// 2 -> ceiling(2/2) == 1번 줄 || (2 - 1 == 1) mod (2) + 1 -> 2 번 째

// 3 -> ceiling(3/2) == 2번 줄 || (3 - 1 == 2) mod (2) + 1 -> 1 번 째

// 4 -> ceiling(4/2) == 2번 줄 || (4 - 1 == 3) mod (2) + 1 -> 2 번 째