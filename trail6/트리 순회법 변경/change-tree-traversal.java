import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] preOrder;
    public static StringBuilder sb = new StringBuilder();
    
    public static void dfs(int left, int right) {
        if(left > right) return;

        int root = preOrder[left];
        int mid = left + 1;

        while(mid <= right && root > preOrder[mid]) {
            mid++;
        }

        dfs(left + 1, mid - 1);
        dfs(mid, right);
        sb.append(root).append("\n");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        preOrder = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            preOrder[i] = Integer.parseInt(br.readLine());
        }

        dfs(1, n);

        System.out.print(sb);
    }
}