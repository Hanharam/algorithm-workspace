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
    int dist, index;

    public Element(int dist, int index) {
        this.dist = dist;
        this.index = index;
    }

    @Override
    public int compareTo(Element e) {
        return dist - e.dist;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        ArrayList<Node>[] graph = new ArrayList[n + 1];
        PriorityQueue<Element> pq = new PriorityQueue<>();
        int dist[] = new int[n + 1];

        Arrays.fill(dist, (int)1e9);

        for(int i = 0; i <= n; i++) {
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

        dist[k] = 0;

        pq.add(new Element(0, k));

        while(!pq.isEmpty()) {
            Element cur = pq.poll();
            int curIndex = cur.index;
            int curDist = cur.dist;

            if(cur.dist != dist[curIndex]) continue;

            for(int i = 0; i < graph[curIndex].size(); i++) {
                Node next = graph[curIndex].get(i);

                int newDist = dist[curIndex] + next.dist;
                if(dist[next.index] > newDist) {
                    dist[next.index] = newDist;
                    pq.add(new Element(newDist, next.index));
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            if(dist[i] == (int)1e9) System.out.println(-1);
            else System.out.println(dist[i]);
        }
    }
}