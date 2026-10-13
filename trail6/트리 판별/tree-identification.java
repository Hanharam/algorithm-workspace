import java.util.*;
import java.io.*;

public class Main {
    public static int m;
    public static ArrayList<Integer>[] tree = new ArrayList[10001];
    public static boolean[] activate = new boolean[10001];
    public static int[] inDgree = new int[10001];
    public static boolean[] visited = new boolean[10001];
    public static boolean duplicated = false;

    public static boolean isTree() {
        int root = -1;
        for(int i = 1; i <= 10000; i++) {
            if(activate[i] && inDgree[i] == 0) root = i;
        }

        if(root == -1) return false;

        for(int i = 1; i <= 10000; i++) {
            if(i == root) continue;
            if(activate[i] && inDgree[i] != 1) {
                return false;
            };
        }

        dfs(root);
        
        if(duplicated) return false;

        for(int i = 1; i <= 10000; i++) {
            if(activate[i] && !visited[i]) {
                return false;
            }
        }

        return true;
    }

    public static void dfs(int k) {
        if(visited[k]) {
            duplicated = true;
            return;
        }

        visited[k] = true;

        for(int num : tree[k]) {
            dfs(num);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i = 0; i < 10001; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            activate[a] = true;
            activate[b] = true;

            tree[a].add(b);
            inDgree[b]++;
        }

        
        if(isTree()) System.out.print(1);
        else System.out.print(0);
    }
}