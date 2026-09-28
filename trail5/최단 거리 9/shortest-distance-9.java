import java.util.*;
import java.io.*;

class Node {
    int y, z;

    public Node(int y, int z) {
        this.y = y;
        this.z = z;
    }
}

class Element implements Comparable<Element> {
    int dist, index;
    
    public Element(int dist, int index) {
        this.dist = dist;
        this.index = index;
    }

    @Override
    public int compareTo(Element e) {
        return this.dist - e.dist;
    }
}

public class Main {
    public static int n, m;
    public static int[] path, dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        path = new int[n + 1];
        dist = new int[n + 1];

        ArrayList<Node>[] graph = new ArrayList[n + 1];
        PriorityQueue<Element> pq = new PriorityQueue<>();

        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x  = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            graph[x].add(new Node(y, z));
            graph[y].add(new Node(x, z));
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, (int)1e9);

        pq.add(new Element(0, a));


        dist[a] = 0;
        
        while(!pq.isEmpty()) {
            int minIndex = pq.peek().index;
            int minDist = pq.peek().dist;
            pq.poll();

            if(minDist != dist[minIndex]) continue;

            for(int i = 0; i < graph[minIndex].size(); i++) {
                int targetIndex = graph[minIndex].get(i).y;
                int targetDist = graph[minIndex].get(i).z;

                int newDist = dist[minIndex] + targetDist;

                if(newDist < dist[targetIndex]) {
                    dist[targetIndex] = newDist;
                    pq.add(new Element(newDist, targetIndex));
                    path[targetIndex] = minIndex;
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int x = b;
        while(x != 0) {
            ans.add(x);
            x = path[x];
        }
        
        System.out.println(dist[b]);
        for(int i = ans.size() - 1; i >= 0; i--) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
