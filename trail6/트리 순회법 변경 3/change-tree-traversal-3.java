import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] inOrder, postOrder, inOrderMap, preOrder;
    public static int cnt = 1;

    // l, r -> 후위 순회 범위 || l2, r2 -> 중위 순회 범위
    public static void dfs(int l, int r, int l2, int r2) {
        if(l > r || l2 > r2) return;

        int rootNum = inOrderMap[postOrder[r]];
        int lefSz = rootNum - l2;

        preOrder[cnt++] = postOrder[r];

        dfs(l, l + lefSz - 1, l2, rootNum - 1);
        dfs(l + lefSz, r - 1, rootNum + 1, r2);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        inOrder = new int[n + 1];
        postOrder = new int[n + 1];
        inOrderMap = new int[n + 1];
        preOrder = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
            inOrderMap[inOrder[i]] = i;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, n, 1, n);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(preOrder[i]).append(" ");
        }
        System.out.println(sb);
    }
}