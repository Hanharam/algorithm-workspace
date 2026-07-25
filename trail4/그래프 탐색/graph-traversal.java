import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static ArrayList<Integer>[] graph;
    public static boolean[] visited;
    public static int cnt = 0;

    public static void dfs(int vertex) {
        
        for(int i = 0; i < graph[vertex].size(); i++) {
            int currV = graph[vertex].get(i);

            if(!visited[currV]) {
                cnt++;
                visited[currV] = true;
                dfs(currV);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        visited[1] = true;
        dfs(1);
        System.out.print(cnt);
    }
}