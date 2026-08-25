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

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Node> nodes = new HashMap<>();

        nodes.put(1, new Node(1));

        StringTokenizer st;
        int cnt = 1;
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            
            if(command == 1) {
                int b = Integer.parseInt(st.nextToken());

                Node cur = nodes.get(a);
                Node nCur = cur.next;

                int first = cnt + 1;
                int last = cnt + b;
                for(int j = 1; j <= b; j++) {
                    Node newNode = new Node(cnt + j);
                    nodes.put(cnt + j, newNode);

                    if(j > 1) connect(nodes.get(cnt + j - 1), newNode);
                }
                cnt += b;

                connect(cur, nodes.get(first));
                connect(nodes.get(last), nCur);
            }
            else if(command == 2) {
                int b = Integer.parseInt(st.nextToken());

                Node cur = nodes.get(a);
                Node pCur = cur.prev;

                int first = cnt + 1;
                int last = cnt + b;
                for(int j = 1; j <= b; j++) {
                    Node newNode = new Node(cnt + j);
                    nodes.put(cnt + j, newNode);

                    if(j > 1) connect(nodes.get(cnt + j - 1), newNode);
                }
                cnt += b;

                connect(nodes.get(last), cur);
                connect(pCur, nodes.get(first));
            }
            else if(command == 3) {
                Node cur = nodes.get(a);

                if(cur.prev == null || cur.next == null) sb.append("-1\n");
                else sb.append(cur.prev.num).append(" ").append(cur.next.num).append("\n");
            }
        }
        System.out.print(sb);
    }
}



// 4 5 6 7 1 2 3

// 1 6 2 3 4 5