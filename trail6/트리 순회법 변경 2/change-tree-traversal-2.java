import java.util.*;
import java.io.*;

public class Main {
    public static int[] inOrder, preOrder, inOrderMap, postOrder;
    public static int cnt = 1;
    
    // l, r 전위 순회 범위, l2, r2 중위 순회 범위
    public static void dfs(int l, int r, int l2, int r2) {
        if(l > r) return;

        if(l == r) {
            postOrder[cnt++] = preOrder[l];
            return;
        }

        int root_num = inOrderMap[preOrder[l]];

        // 왼쪽, 오른족 서브트리 노드의 수
        int lefSz = root_num - l2;
        int riSz = r2 - root_num;

        // 왼쪽 서브트리  
        dfs(l + 1, l + lefSz, l2, root_num - 1);
        // 오른쪽 서브트리
        dfs(l + lefSz + 1, r, root_num + 1, r2);

        postOrder[cnt++] = preOrder[l];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        inOrder = new int[n + 1];
        preOrder = new int[n + 1];
        inOrderMap = new int[n + 1];
        postOrder = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            preOrder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
            inOrderMap[inOrder[i]] = i;
        }


        dfs(1, n, 1, n);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <=n; i++) {
            sb.append(postOrder[i]).append(" ");
        }

        System.out.print(sb);
    }
}