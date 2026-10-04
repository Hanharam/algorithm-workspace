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
        return dist - e.dist;
    }
}

public class Main {
    public static int n, m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] graph = new ArrayList[n + 1];
        
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

        PriorityQueue<Element> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];

        for(int i = 1; i <= n; i++)
            dist[i] = (int) 1e9;

        dist[n] = 0;
        pq.add(new Element(n, 0));

        while(!pq.isEmpty()) {
            int minIndex = pq.peek().index;
            int minDist = pq.peek().dist;
            pq.poll();

            if(dist[minIndex] != minDist) continue;

            for(Node e : graph[minIndex]) {
                int targetIndex = e.index;
                int targetDist = e.dist;

                int newDist = minDist + targetDist;
                if(dist[targetIndex] > newDist) {
                    dist[targetIndex] = newDist;
                    pq.add(new Element(targetIndex, newDist));
                }
            }
        }

        int ans = 0;
        for(int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }
        System.out.print(ans);
    }
}