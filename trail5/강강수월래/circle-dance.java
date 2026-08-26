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
    public static HashMap<Integer, Node> nodes = new HashMap<>();
    public static StringBuilder sb = new StringBuilder();

    public static void connect(Node s, Node e) {
        if(s != null) s.next = e;
        if(e != null) e.prev = s;
    }

    public static Node findMin(Node cur) {
        Node start = cur.next;

        Node min = cur;
        while(start != cur) {
            if(start.num < min.num) min = start;
            start = start.next;
        }

        return min;
    }

    public static void printNum(Node cur) {
        Node start = cur;

        do {
            sb.append(start.num).append(" ");
            start = start.prev;
        } while(start != cur);
        sb.append("\n");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            
            Node last = null;
            Node head = null;
            for(int j = 1; j <= num; j++) {
                int inNum = Integer.parseInt(st.nextToken());
                Node cur = new Node(inNum);
                nodes.put(inNum, cur);
                
                if(j == 1) {
                    head = cur;
                }
                else {
                    connect(last, cur);
                }
                last = cur;
            }
            connect(last, head);
        }

        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            
            if(command == 1) {
                int b = Integer.parseInt(st.nextToken());

                Node nextA = nodes.get(a).next;
                Node prevB = nodes.get(b).prev;

                connect(nodes.get(a), nodes.get(b));
                connect(prevB, nextA);
            }
            else if(command == 2) {
                int b = Integer.parseInt(st.nextToken());

                Node prevB = nodes.get(b).prev;
                Node prevA = nodes.get(a).prev;

                connect(prevB, nodes.get(a));
                connect(prevA, nodes.get(b));
            }
            else if(command == 3) {
                Node min = findMin(nodes.get(a));
                printNum(min);
            }
        }
        System.out.print(sb);
    }
}