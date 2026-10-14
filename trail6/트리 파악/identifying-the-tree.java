import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static ArrayList<Integer>[] edges;
    public static boolean[] visited;
    public static int count = 0;

    public static void dfs(int k, int depth) {
        boolean isLeaf = true;
        visited[k] = true;
        
        for(int num : edges[k]) {
            
            if(!visited[num]) {
                dfs(num, depth + 1);
                isLeaf = false;
            }
        }

        if(isLeaf) count += depth;
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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges[a].add(b);
            edges[b].add(a);
        }

        visited = new boolean[n + 1];
        dfs(1, 0);

        if(count%2 == 1) System.out.print(1);
        else System.out.print(0);
    }
}