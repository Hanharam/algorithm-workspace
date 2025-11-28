package boj.backtracking.b10971;

import java.io.*;
import java.util.*;

public class Main {

    public static int[][] w;
    static int n;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        w = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n];
        for (int start = 0; start < n; start++) {
            Arrays.fill(visited, false);
            visited[start] = true;
            hamiltonian_circuit(start, start, 1, 0);
        }
        System.out.println(answer);
    }


    public static void hamiltonian_circuit(int start, int now, int depth, int cost) {
        if(cost >= answer) return;

        if (depth == n) {
            if (w[now][start] != 0) {
                answer = Math.min(answer, cost + w[now][start]);
            }
            return;
        }

        for (int next = 0; next < n; next++) {
            if (!visited[next] && w[now][next] != 0) {
                visited[next] = true;
                hamiltonian_circuit(start, next, depth + 1, cost + w[now][next]);
                visited[next] = false;
            }
        }
    }
}
