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
    public static int n, m, x;
    public static ArrayList<Node>[] graph = new ArrayList[1000 + 1];
    public static ArrayList<Node>[] reverseG = new ArrayList[1000 + 1];

    public static int[] dist = new int[1001];
    public static int[] reverseD = new int[1001];

    public static void dijkstra(int k, int[] dist, ArrayList<Node>[] graph) {
        PriorityQueue<Element> pq = new PriorityQueue<>();
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
        x = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            reverseG[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            graph[x].add(new Node(y, z));
            reverseG[y].add(new Node(x, z));
        }

        dijkstra(x, dist, graph);
        dijkstra(x, reverseD, reverseG);

        int ans = 0;
        for(int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i] + reverseD[i]);
        }
        System.out.print(ans);
    }
}