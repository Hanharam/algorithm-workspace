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

    public int compareTo(Element  e) {
        if(this.dist != e.dist) return this.dist - e.dist;
        else return index - e.index;
    }
}

public class Main {
    public static int n, m;
    public static int[] path = new int[1001];
    public static ArrayList<Node>[] graph = new ArrayList[1001];
    public static int[] dist = new int[1001];
    public static boolean[][] checked = new boolean[1001][1001];
    public static boolean[][] validDir = new boolean[1001][1001];


    public static void dijkstra() {
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

                if(checked[minIndex][targetIndex]) continue;

                int newDist = minDist + targetDist;
            
                if(dist[targetIndex] > minDist + targetDist) {
                    dist[targetIndex] = minDist + targetDist;
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

        dijkstra();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[1001];

        q.add(n);
        visited[n] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            if(cur == 1) continue;

            for(Node prevNode : graph[cur]) {
                int prev = prevNode.index;
                int weight = prevNode.dist;

                if(dist[prev] + weight == dist[cur]) {
                    validDir[prev][cur] = true;

                    if(!visited[prev]) {
                        visited[prev] = true;
                        q.add(prev);
                    }
                }
            }
        }

        int cur = 1;
        while(cur != n) {
            int nextNode = -1;

            for(int v = 1; v <= n; v++) {
                if(validDir[cur][v]) {
                    nextNode = v;
                    break;
                }
            }

            checked[cur][nextNode] = true;
            checked[nextNode][cur] = true;

            cur = nextNode;
        }
        

        dijkstra();

        int ans;
        if(dist[n] == (int) 1e9) ans = -1;
        else ans = dist[n];

        System.out.print(ans);
    }
}