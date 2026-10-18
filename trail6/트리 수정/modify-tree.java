import java.util.*;
import java.io.*;

// 그래프 간선 저장
class Edge {
    int to, dist, id;

    public Edge(int to, int dist, int id) {
        this.to = to;
        this.dist = dist;
        this.id = id;
    }
}

// 제거할 간선 후보
class Info {
    int x, y, dist;

    public Info(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class Main {
    public static int n, tempPoint;
    public static ArrayList<Edge>[] edges;
    public static Info[] edgeArray;
    public static boolean[] visited;
    public static long maxDist;

    public static void dfs(int current, long dist, int removedEdgeId) {
        visited[current] = true;

        if(dist > maxDist) {
            tempPoint = current;
            maxDist = dist;
        }

        for(Edge e : edges[current]) {
            if(visited[e.to]) continue;
            if(e.id == removedEdgeId) continue; // 제거된 간선은 방문하지 않음

            dfs(e.to, dist + e.dist, removedEdgeId);
        }
    }


    // 지름 구하기
    public static long getDiameter(int current, int removedEdgeId) {
        visited = new boolean[n];
        maxDist = -1;
        dfs(current, 0, removedEdgeId);
        int start = tempPoint;

        visited = new boolean[n];
        maxDist = -1;
        dfs(start, 0, removedEdgeId);

        return maxDist;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        edgeArray = new Info[n - 1];
        edges = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            edgeArray[i] = new Info(x, y, dist);

            edges[x].add(new Edge(y, dist, i));
            edges[y].add(new Edge(x, dist, i));
        }

        long answer = 0;
        // 간선 하나씩 지우면서 MAX(좌 + 우 + 제거한 간선) 구하기
        for(int i = 0; i < n - 1; i++) {
            Info edge = edgeArray[i];

            long leftDiameter = getDiameter(edge.x, i);
            long rightDiameter = getDiameter(edge.y, i);

            long candidate = leftDiameter + rightDiameter + edge.dist;

            answer = Math.max(answer, candidate);
        }
        System.out.print(answer);
    }
}