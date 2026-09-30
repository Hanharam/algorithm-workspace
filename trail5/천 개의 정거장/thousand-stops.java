import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int to, time;
    long cost;

    public Node(int to, long cost, int time) {
        this.to = to;
        this.cost = cost;
        this.time = time;
    }

    @Override
    public int compareTo(Node n) {
        if (this.cost != n.cost) return Long.compare(this.cost, n.cost);
        return Integer.compare(this.time, n.time);
    }
}

public class Main {
    public static int a, b, n;
    public static ArrayList<Node>[] graph = new ArrayList[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 1001; i++) {
            graph[i] = new ArrayList<>();
        }

        // 중복 간선 방지를 위한 2차원 배열
        long[][] minCost = new long[1001][1001];
        int[][] minTime = new int[1001][1001];

        for (int i = 0; i < 1001; i++) {
            Arrays.fill(minCost[i], Long.MAX_VALUE);
            Arrays.fill(minTime[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long cost = Long.parseLong(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] route = new int[k];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                route[j] = Integer.parseInt(st.nextToken());
            }

            // 최선의 간선 정보만 minCost / minTime에 갱신
            for (int l = 0; l < k; l++) {
                for (int m = l + 1; m < k; m++) {
                    int from = route[l];
                    int to = route[m];
                    int time = m - l;

                    if (cost < minCost[from][to] || (cost == minCost[from][to] && time < minTime[from][to])) {
                        minCost[from][to] = cost;
                        minTime[from][to] = time;
                    }
                }
            }
        }

        // 갱신된 단 하나의 최선 간선들만 그래프에 추가
        for (int u = 1; u <= 1000; u++) {
            for (int v = 1; v <= 1000; v++) {
                if (minCost[u][v] != Long.MAX_VALUE) {
                    graph[u].add(new Node(v, minCost[u][v], minTime[u][v]));
                }
            }
        }

        // 다익스트라 수행
        long[][] dist = new long[1001][2]; // 0: 비용, 1: 시간
        for (int i = 0; i < 1001; i++) {
            dist[i][0] = Long.MAX_VALUE;
            dist[i][1] = Long.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[a][0] = 0;
        dist[a][1] = 0;
        pq.add(new Node(a, 0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curIndex = cur.to;
            long curCost = cur.cost;
            int curTime = cur.time;

            if (dist[curIndex][0] < curCost || 
               (dist[curIndex][0] == curCost && dist[curIndex][1] < curTime)) continue;

            for (Node next : graph[curIndex]) {
                int nextIndex = next.to;
                long newCost = curCost + next.cost;
                int newTime = curTime + next.time;

                if (newCost < dist[nextIndex][0] || 
                   (newCost == dist[nextIndex][0] && newTime < dist[nextIndex][1])) {
                    dist[nextIndex][0] = newCost;
                    dist[nextIndex][1] = newTime;
                    pq.add(new Node(nextIndex, newCost, newTime));
                }
            }
        }

        if (dist[b][0] == Long.MAX_VALUE) System.out.print("-1 -1");
        else System.out.print(dist[b][0] + " " + dist[b][1]);
    }
}
