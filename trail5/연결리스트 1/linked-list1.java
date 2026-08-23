import java.util.*;
import java.io.*;

class Node {
    String str;
    Node next, prev;

    public Node(String str) {
        this.str = str;
        this.next = null;
        this.prev = null;
    }
}

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static Node insertPrev(Node cur, String str) {
        Node newNode = new Node(str);

        newNode.next = cur;
        newNode.prev = cur.prev;


        if(newNode.prev != null) newNode.prev.next = newNode;
        if(newNode.next != null) newNode.next.prev = newNode;

        return cur;
    }

    public static Node insertNext(Node cur, String str) {
        Node newNode = new Node(str);

        newNode.next = cur.next;
        newNode.prev = cur;


        if(newNode.prev != null) newNode.prev.next = newNode;
        if(newNode.next != null) newNode.next.prev = newNode;

        return cur;
    }

    public static Node movePrev(Node cur) {
        if(cur.prev != null) return cur.prev;
        return cur;
    }

    public static Node moveNext(Node cur) {
        if(cur.next != null) return cur.next;
        return cur;
    }

    public static void printAnswer(Node cur) {
        if(cur.prev != null) sb.append(cur.prev.str).append(" ");
        else sb.append("(Null) ");

        sb.append(cur.str).append(" ");

        if(cur.next != null) sb.append(cur.next.str).append(" \n");
        else sb.append("(Null) \n");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node cur = new Node(br.readLine());

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if(command == 1) {
                cur = insertPrev(cur, st.nextToken());
            }
            else if(command == 2) {
                cur = insertNext(cur, st.nextToken());
            }
            else if(command == 3) {
                cur = movePrev(cur);
            }
            else if(command == 4) {
                cur = moveNext(cur);
            }

            printAnswer(cur);
        }
        System.out.print(sb);
    }
}