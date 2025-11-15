package boj.graph.b6086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// MaxFlow Algorithm
public class Main {
    static final int SIZE = 52;
    static int[][] capacity = new int[SIZE][SIZE];
    static int[][] flow = new int[SIZE][SIZE];
    static List<Integer>[] adj = new ArrayList[SIZE];

    static int toIndex(char c){
        if('A' <= c && c<= 'Z') return c - 'A';
        return c - 'a' + 26;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < SIZE; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = toIndex(st.nextToken().charAt(0));
            int v = toIndex(st.nextToken().charAt(0));
            int c = Integer.parseInt(st.nextToken());

            capacity[u][v] += c;
            capacity[v][u] += c;
            adj[u].add(v);
            adj[v].add(u);
        }

        int source = toIndex('A');
        int sink = toIndex('Z');

        System.out.println(maxFlow(source, sink));
    }

    static int maxFlow(int s, int t){
        int totalFlow = 0;
        int[] parent = new int[SIZE];

        while(true){
            Arrays.fill(parent, -1);
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(s);
            parent[s] = s;

            while (!q.isEmpty() && parent[t] == -1) {
                int cur = q.poll();
                for(int next : adj[cur]){
                    if (capacity[cur][next] - flow[cur][next] > 0 && parent[next] == -1) {
                        parent[next] = cur;
                        q.offer(next);
                    }
                }
            }

            if(parent[t] == -1) break;

            int amount = Integer.MAX_VALUE;
            for(int i = t; i != s; i = parent[i]) {
                int p = parent[i];
                amount = Math.min(amount, capacity[p][i] - flow[p][i]);
            }

            for (int i = t; i != s; i = parent[i]) {
                int p = parent[i];
                flow[p][i] += amount;
                flow[i][p] -= amount;
            }
            totalFlow += amount;
        }
        return totalFlow;
    }
}
