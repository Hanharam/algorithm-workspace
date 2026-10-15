import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static ArrayList<Integer>[] edges;
    public static boolean[] visited;
    public static int root;
    public static int maxDist;

    public static void dfs(int k, int dist) {
        if(visited[k]) return;
        visited[k] = true;

        if(maxDist < dist) {
            maxDist = dist;
            root = k;
        }

        for(int num : edges[k]) {
            dfs(num, dist + 1);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        edges = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            edges[x].add(y);
            edges[y].add(x);
        }

        maxDist = -1;
        visited = new boolean[n + 1];
        dfs(1, 0);

        maxDist = -1;
        visited = new boolean[n + 1];
        dfs(root, 0);

        System.out.print((maxDist + 1) / 2);
    }
}

/*
간선 길이 = 1
다른 모든 정점과의 거리의 최댓값이, 최소가 되는 노드

두루두루 거리가 가까운 노드 찾기

-> 가장 긴 노드 중간 지점에 있는 것 
-> 그게 가장 작지 않을까? 라는 가설을 세워봅니다.
*/