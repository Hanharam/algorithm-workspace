import java.util.*;
import java.io.*;

class Node {
    int num;
    Node prev, next;

    public Node(int num) {
        this.num = num;
        this.prev = null;
        this.next = null;
    }
}

public class Main {
    public static HashMap<Integer, Node> nodes = new HashMap<>();
    public static StringBuilder sb = new StringBuilder();

    public static void deleteNode(Node cur) {
        if(cur.prev != null) cur.prev.next = cur.next;
        if(cur.next != null) cur.next.prev = cur.prev;

        cur.next = null;
        cur.prev = null;
    }

    public static void insertPrev(Node cur, Node newNode) {
        newNode.next = cur;
        newNode.prev = cur.prev;

        if(newNode.prev != null) newNode.prev.next = newNode;
        if(newNode.next != null) newNode.next.prev = newNode;
    }
    
    public static void insertNext(Node cur, Node newNode) {
        newNode.prev = cur;
        newNode.next = cur.next;

        if(newNode.prev != null) newNode.prev.next = newNode;
        if(newNode.next != null) newNode.next.prev = newNode;
    }

    public static void printPrevNext(Node cur) {
        if(cur.prev != null) sb.append(cur.prev.num).append(" ");
        else sb.append("0 ");

        if(cur.next != null) sb.append(cur.next.num).append(" \n");
        else sb.append("0 \n");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) {
            nodes.put(i, new Node(i));
        }

        int q = Integer.parseInt(br.readLine());

        for(int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            if(command == 1) {
                Node cur = nodes.get(l);
                deleteNode(cur);
            }
            else if(command == 2) {
                int j = Integer.parseInt(st.nextToken());
                insertPrev(nodes.get(l), nodes.get(j));
            }
            else if(command == 3) {
                int j = Integer.parseInt(st.nextToken());
                insertNext(nodes.get(l), nodes.get(j));
            }
            else if(command == 4) {
                printPrevNext(nodes.get(l));
            }
        }

        for(int i = 1; i <= n; i++) {
            Node cur = nodes.get(i);

            if(cur.next != null) sb.append(cur.next.num).append(" ");
            else sb.append("0 ");
        }
        System.out.print(sb);
    }
}