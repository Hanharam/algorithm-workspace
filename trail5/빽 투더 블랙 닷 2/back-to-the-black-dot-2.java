import java.util.*;
import java.io.*;

class Node {
    int index, dist;

    public Node(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }
}

class Element implements Comparable<Element>{
    int index, dist;

    public Element(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }

    @Override
    public int compareTo(Element e) {
        return this.dist - e.dist;
    }
}

public class Main {
    public static int n, m;
    public static ArrayList<Node>[] graph;

    public static int[] dist;

    public static void dijkstra(int k) {
        PriorityQueue<Element> pq = new PriorityQueue<>();
        dist = new int[n + 1];
        Arrays.fill(dist, (int) 1e9);

        dist[k] = 0;
        pq.add(new Element(k, 0));

        while(!pq.isEmpty()) {
            int minIndex = pq.peek().index;
            int minDist = pq.peek().dist;
            pq.poll();

            if(dist[minIndex] != minDist) continue;

            for(Node n : graph[minIndex]) {
                int targetIndex = n.index;
                int targetDist = n.dist;

                int newDist = minDist + targetDist;

                if(dist[targetIndex] > newDist) {
                    dist[targetIndex] = newDist;
                    pq.add(new Element(targetIndex, newDist));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int red1 = Integer.parseInt(st.nextToken());
        int red2 = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];

        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            graph[x].add(new Node(y, z));
            graph[y].add(new Node(x, z));
        }

        int[] distSum = new int[n + 1];

        dijkstra(red1);
        for(int i = 1; i <= n; i++) {
            distSum[i] += dist[i];
        }
        dijkstra(red2);
        for(int i = 1; i <= n; i++) {
            distSum[i] += dist[i];
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            if(i == red1 || i == red2) continue;
            if(distSum[i] >= (int) 1e9) continue;
            
            ans = Math.min(ans, distSum[i]);
        }

        if(ans == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.print(ans + dist[red1]);
    }
}