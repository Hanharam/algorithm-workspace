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
    public static ArrayList<Node>[] graph = new ArrayList[1001];
    public static int[] dist = new int[1001];
    public static int[] path = new int[1001];

    public static void dijkstra(int x, int y) {
        PriorityQueue<Element> pq = new PriorityQueue<>();
        for(int i = 1; i <= n; i++) {
            dist[i] = (int) 1e9;
        }

        dist[1] = 0;
        pq.add(new Element(1, 0));
        
        while(!pq.isEmpty()) {
            int minIndex = pq.peek().index;
            int minDist = pq.peek().dist;
            pq.poll();

            if(dist[minIndex] != minDist) continue;

            for(Node n : graph[minIndex]) {
                int targetIndex = n.index;
                int targetDist = n.dist;

                if((x == minIndex && y == targetIndex) || (x == targetIndex && y == minIndex))
                    continue;

                int newDist = minDist + targetDist;

                if(dist[targetIndex] > newDist) {
                    dist[targetIndex] = newDist;
                    pq.add(new Element(targetIndex, newDist));
                    path[targetIndex] = minIndex;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            graph[x].add(new Node(y, z));
            graph[y].add(new Node(x, z));
        }

        dijkstra(0, 0);

        int originDist = dist[n];

        ArrayList<Integer> vertices = new ArrayList<>();
        int cur = n;
        while(cur != 1) {
            vertices.add(cur);
            cur = path[cur];
        }
        vertices.add(1);

        int ans = 0;
        for(int i = vertices.size() - 1; i >= 1; i--) {
            int x = vertices.get(i);
            int y = vertices.get(i - 1);

            dijkstra(x, y);

            if(originDist != dist[n]) ans++;
        }
        System.out.print(ans);
    }
}