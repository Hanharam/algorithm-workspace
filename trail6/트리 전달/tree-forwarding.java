import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static ArrayList<Integer>[] tree;
    public static int[] score;

    public static void dfs(int i) {
        for(int next : tree[i]) {
            score[next] += score[i];
            dfs(next);
        }
    }
    

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        score = new int[n + 1];

        tree = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) continue;

            tree[parent].add(i);
        }

        for(int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            score[i] += w;
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(score[i]).append(" ");
        }

        System.out.print(sb);
    }
}

// 부모가 하나