import java.util.*;
import java.io.*;

class Edge {
    int index, dist, id;

    public Edge(int index, int dist, int id) {
        this.index = index;
        this.dist = dist;
        this.id = id;
    }
}

class OriginalEdge {
    int x, y, dist;

    public OriginalEdge(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class Main {
    public static int n, tempPoint;
    public static long maxDist;
    public static ArrayList<Edge>[] edges;
    public static OriginalEdge[] originalEdges;

    public static boolean[] visited;

    public static void dfs(int current, long dist, int removedEdgeId) {
        visited[current] = true;

        if(dist > maxDist) {
            maxDist = dist;
            tempPoint = current;
        }

        for(Edge edge : edges[current]) {
            if(edge.id == removedEdgeId) {
                continue;
            }

            if(visited[edge.index]) {
                continue;
            }

            dfs(edge.index, dist + edge.dist, removedEdgeId);
        }
    }

    public static long getDiameter(int start, int removedEdgeId) {
        visited = new boolean[n];
        maxDist = -1;

        dfs(start, 0, removedEdgeId);

        int diameterStart = tempPoint;

        visited = new boolean[n];
        maxDist = -1;

        dfs(diameterStart, 0, removedEdgeId);

        return maxDist;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        edges = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        originalEdges = new OriginalEdge[n];

        for(int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            originalEdges[i] = new OriginalEdge(x, y, z);

            edges[x].add(new Edge(y, z, i));
            edges[y].add(new Edge(x, z, i));
        }

        long answer = 0;

        for(int removedEdgeId = 0; removedEdgeId < n - 1; removedEdgeId++) {
            OriginalEdge removed = originalEdges[removedEdgeId];

            long leftDiameter = getDiameter(removed.x, removedEdgeId);

            long rightDiameter = getDiameter(removed.y, removedEdgeId);

            long candidate = leftDiameter + rightDiameter + removed.dist;

            answer = Math.max(answer, candidate);
        }
        
        System.out.print(answer);
    }
}