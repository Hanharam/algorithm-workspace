import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int sum, a, b;

    public Node(int sum, int a, int b) {
        this.sum = sum;
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Node n) {
        return this.sum - n.sum;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            pq.add(new Node(a[i] + b[0], i, 0));
        }

        int ans = 0;

        for(int i = 0; i < k; i++) {
            Node cur = pq.poll();

            ans = cur.sum;

            if(cur.b + 1 < m) {
                pq.add(
                    new Node(
                        a[cur.a] + b[cur.b+1],
                        cur.a,
                        cur.b+1
                    )
                );
            }
        }

        System.out.print(ans);
    }
}