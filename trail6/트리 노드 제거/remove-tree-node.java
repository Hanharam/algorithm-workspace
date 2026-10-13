import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] parent;
    public static int count = 0;
    public static int erase;

    public static void dfs(int k) {
        boolean isLeaf = true;
        
        for(int i = 0; i < n; i++) {
            if(parent[i] == k && i != erase) {
                dfs(i);
                isLeaf = false;
            }
        }
        if(isLeaf) count++;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        parent = new int[n];

        int root = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            if(parent[i] == -1) root = i;
        }

        erase = Integer.parseInt(br.readLine());

        if(erase == root) System.out.print(0);
        else {
            dfs(root);
            System.out.print(count);
        }
        
    }
}