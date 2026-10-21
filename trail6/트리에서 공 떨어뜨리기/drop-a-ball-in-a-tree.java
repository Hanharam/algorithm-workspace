import java.util.*;
import java.io.*;

class Node {
    int left, right;

    public Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class Main {
    public static int n, answer;
    public static long k;
    public static Node[] nodes;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nodes = new Node[n + 1];
        
        StringTokenizer st;
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(left, right);
        }

        k = Long.parseLong(br.readLine());
        int current = 1;

        while(true) {
            Node node = nodes[current];

            if(node.left == -1 && node.right == -1) {
                break;
            }

            if(node.left == -1) {
                current = node.right;
            } else if(node.right == -1) {
                current = node.left;
            }

            else if(k % 2 == 1) {
                current = node.left;
                k = (k + 1) / 2;
            } else {
                current = node.right;
                k /= 2;
            }
        }
        System.out.print(current);
    }
}