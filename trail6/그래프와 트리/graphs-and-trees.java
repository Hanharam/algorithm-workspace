import java.util.*;
import java.io.*;

// 이미 갔던 곳은 visited 처리하는데 
// 사이클을 어떻게 잡아내지? 진짜 모름.
// 
public class Main {
    public static int n, m;
    public static ArrayList<Integer>[] edges;
    public static boolean[] visited;

    public static boolean dfs(int k, int parent) {
        visited[k] = true;

        for(int next : edges[k]) {
            if(next == parent) continue;

            if(visited[next]) return false;

            if(!dfs(next, k)) return false;
        }
        
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        edges = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            edges[x].add(y);
            edges[y].add(x);
        }

        visited = new boolean[n + 1];
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            if(!visited[i] && dfs(i, 0))
                ans++;
        }

        System.out.print(ans);
    }
}