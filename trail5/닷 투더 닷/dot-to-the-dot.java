import java.util.*;
import java.io.*;

class Node {
    int index, l, c;

    public Node(int index, int l, int c) {
        this.index = index;
        this.l = l;
        this.c = c;
    }
}

class Element implements Comparable<Element>{
    int index;
    long dist;

    public Element(int index, long dist) {
        this.index = index;
        this.dist = dist;
    }

    @Override
    public int compareTo(Element e) {
        return Long.compare(dist, e.dist);
    }
}

public class Main {
    public static int MAX_N = 500;

    public static int n, m, x;
    public static ArrayList<Node>[] graph = new ArrayList[MAX_N + 1];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        HashSet<Integer> cValues = new HashSet<>();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, l, c));
            graph[to].add(new Node(from, l, c));
            cValues.add(c);
        }

        double minTotalCost = Double.MAX_VALUE;

        for(int limitC : cValues) {
            long[] dist = new long[n + 1];
            Arrays.fill(dist, Long.MAX_VALUE);
            PriorityQueue<Element> pq = new PriorityQueue<>();

            dist[1] = 0;
            pq.add(new Element(1, 0));

            while(!pq.isEmpty()) {
                int curIndex = pq.peek().index;
                long curDist = pq.peek().dist;
                pq.poll();

                if(curDist != dist[curIndex]) continue;

                for(Node next : graph[curIndex]) {
                    if(next.c < limitC) continue;

                    long newDist = curDist + next.l;
                    if(newDist < dist[next.index]) {
                        dist[next.index] = newDist;
                        pq.add(new Element(next.index, newDist));
                    }
                }
            }

            if(dist[n] != Long.MAX_VALUE) {
                double curCost = dist[n] + (double) x / limitC;
                minTotalCost = Math.min(minTotalCost, curCost);
            }
        }

        System.out.print((int) minTotalCost);
    }
}