import java.util.*;
import java.io.*;

class Pair {
    long cost, time;

    public Pair(long cost, long time) {
        this.cost = cost;
        this.time = time;
    }

    public boolean isGreaterThan(Pair p) {
        return this.cost > p.cost || 
        (this.cost == p.cost && this.time > p.time);
    }
}

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final long INF = (long)1e17 + 1;
    public static final int MAX_M = 1000;

    public static int a, b, n, m = 1000;
    public static Pair[][] graph = new Pair[MAX_M + 1][MAX_M + 1];
    public static boolean[] visited = new boolean[MAX_M + 1];

    public static Pair[] dist = new Pair[MAX_M + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= m; i++) {
            for(int j = 1; j <= m; j++) {
                graph[i][j] = new Pair(INF, 0);
            }
            graph[i][i] = new Pair(0, 0);
        }

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int stopNum = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> stops = new ArrayList<>();
            for(int j = 0; j < stopNum; j++) {
                int x = Integer.parseInt(st.nextToken());
                stops.add(x);
            }

            for(int j = 0; j < stopNum; j++) {
                for(int k = j + 1; k < stopNum; k++) {
                    Pair newP = new Pair(cost, k - j);
                    if(graph[stops.get(j)][stops.get(k)].isGreaterThan(newP))
                        graph[stops.get(j)][stops.get(k)] = newP;
                }
            }
        }


        for(int i = 1; i <= m; i++) {
            dist[i] = new Pair(INF, 0);
        }

        dist[a] = new Pair(0, 0);

        for(int i = 1; i <= m; i++) {
            int minIndex = -1;
            for(int j = 1; j <= m; j++) {
                if(visited[j]) continue;

                if(minIndex == -1 || dist[minIndex].isGreaterThan(dist[j]))
                    minIndex = j;
            }

            visited[minIndex] = true;

            long minCost = dist[minIndex].cost;
            long minTime = dist[minIndex].time;

            for(int j = 1; j <= m; j++) {
                long cost = graph[minIndex][j].cost;
                long time = graph[minIndex][j].time;
                Pair newP = new Pair(minCost + cost, minTime + time);
                if(dist[j].isGreaterThan(newP))
                    dist[j] = newP;
            }
        }

        if(dist[b].cost == INF)
            dist[b] = new Pair(-1, -1);

        System.out.print(dist[b].cost + " " + dist[b].time);
    }
}
