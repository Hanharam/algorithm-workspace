import java.util.*;
import java.io.*;

class Edge {
    int e, v;

    public Edge(int e, int v) {
        this.e = e;
        this.v = v;
    }
}

class Node implements Comparable<Node>{
    int idx, dist;

    public Node(int idx, int dist) {
        this.idx = idx;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node n) {
        if(dist != n.dist) return dist - n.dist;
        return idx - n.idx;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        ArrayList<Edge>[] list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[s].add(new Edge(e, v));
        }

        dist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int curIdx = cur.idx;
            int curDist = cur.dist;

            if(curDist > dist[curIdx]) continue;

            for(Edge edge : list[curIdx]) {
                int nextIdx = edge.e;
                int nextDist = curDist + edge.v;

                if(nextDist < dist[nextIdx]) {
                    dist[nextIdx] = nextDist;
                    pq.add(new Node(nextIdx, nextDist));
                }
            }
        }

        for(int i = 2; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(dist[i]);
        }
    }
}