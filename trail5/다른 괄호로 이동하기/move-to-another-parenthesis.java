import java.util.*;
import java.io.*;

class Node {
    int index, dist;

    public Node(int index, int dist) {
        this.index = index;
        this.dist = dist;
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
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int DIR_NUM = 4;
    public static final int MAX_M = 900;
    public static final int MAX_N = 30;

    public static int n, m, a, b;
    public static char[][] brackets = new char[MAX_N + 1][MAX_N + 1];
    public static int[][] nodeNum = new int[MAX_N + 1][MAX_N + 1];
    public static ArrayList<Node>[] graph = new ArrayList[MAX_M + 1];
    public static PriorityQueue<Element> pq = new PriorityQueue<>();

    public static int[] dist = new int[MAX_M + 1];
    public static int ans;

    public static boolean inRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= n;
    }

    public static void makeGraph() {
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++) 
                nodeNum[i][j] = ++m;
        
        for(int i = 1; i <= m; i++)
            graph[i] = new ArrayList<>();

        for(int x = 1; x <= n; x++) {
            for(int y = 1; y <= n; y++) {
                int[] dx = new int[]{1, -1, 0, 0};
                int[] dy = new int[]{0, 0, 1, -1};

                for(int k = 0; k < DIR_NUM; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if(!inRange(nx, ny)) continue;

                    int node1 = nodeNum[x][y];
                    int node2 = nodeNum[nx][ny];

                    if(brackets[x][y] == brackets[nx][ny]) {
                        graph[node1].add(new Node(node2, a));
                    } else {
                        graph[node1].add(new Node(node2, b));
                    }
                }
            }
        }
    }

    public static void dijkstra(int k) {
        for(int i = 1; i <= m; i++) {
            dist[i] = (int) 1e9;
        }

        dist[k] = 0;

        pq.add(new Element(0, k));

        while(!pq.isEmpty()) {
            int minDist = pq.peek().dist;
            int minIndex = pq.peek().index;
            pq.poll();

            if(minDist != dist[minIndex]) continue;

            for(int i = 0; i < graph[minIndex].size(); i++) {
                int targetDist = graph[minIndex].get(i).dist;
                int targetIndex = graph[minIndex].get(i).index;

                int newDist = minDist + targetDist;

                if(dist[targetIndex] > newDist) {
                    dist[targetIndex] = newDist;
                    pq.add(new Element(newDist, targetIndex));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        
        for(int i = 1; i <= n; i++) {
            String row = br.readLine();
            for(int j = 1; j <= n; j++) {
                brackets[i][j] = row.charAt(j - 1);
            }
        }

        makeGraph();

        for(int i = 1; i <= m; i++) {
            dijkstra(i);

            for(int j = 1; j <= m; j++) {
                ans = Math.max(ans, dist[j]);
            }
        }
        System.out.print(ans);
    }
}