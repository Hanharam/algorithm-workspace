import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
    int to;
    long weight;

    public Edge(int to, long weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge e) {
        return Long.compare(this.weight, e.weight);
    }
}

class OriginalEdge {
    int u, v;
    long wA, wB;

    public OriginalEdge(int u, int v, long wA, long wB) {
        this.u = u; this.v = v;
        this.wA = wA; this.wB = wB;
    }
}

public class Main {
    public static final long INF = Long.MAX_VALUE / 2;

    public static int n, m;
    public static ArrayList<Edge>[] revGraphA;
    public static ArrayList<Edge>[] revGraphB;
    public static ArrayList<Edge>[] graphC;
    public static ArrayList<OriginalEdge> edgeList = new ArrayList<>();
    
    public static long[] dijkstra(int start, ArrayList<Edge>[] graph) {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            int curIndex = cur.to;
            long curDist = cur.weight;

            if(dist[curIndex] != curDist) continue;

            for(Edge next : graph[curIndex]) {
                long newDist = curDist + next.weight;
                if(dist[next.to] > newDist) {
                    dist[next.to] = newDist;
                    pq.add(new Edge(next.to, newDist));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        revGraphA = new ArrayList[n + 1];
        revGraphB = new ArrayList[n + 1];
        graphC = new ArrayList[n + 1];


        for(int i = 1; i <= n; i++) {
            revGraphA[i] = new ArrayList<>();
            revGraphB[i] = new ArrayList<>();
            graphC[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edgeList.add(new OriginalEdge(x, y, a, b));
            revGraphA[y].add(new Edge(x, a));
            revGraphB[y].add(new Edge(x, b));
        }

        long[] distA = dijkstra(n, revGraphA);
        long[] distB = dijkstra(n, revGraphB);

        for(OriginalEdge e : edgeList) {
            int warningCount = 0;

            if(distA[e.u] != e.wA + distA[e.v]) warningCount++;
            if(distB[e.u] != e.wB + distB[e.v]) warningCount++;

            graphC[e.u].add(new Edge(e.v, warningCount));
        }

        long[] distC = dijkstra(1, graphC);

        System.out.println(distC[n]);
    }

    public static void printArr(int[] path) {
        for(int i = 1; i <= n; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }
}