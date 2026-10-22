import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] preOrder, inOrder;
    public static int[] inOrderIndexMap;
    public static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        preOrder = new int[n + 1];
        inOrder = new int[n + 1];
        inOrderIndexMap = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            preOrder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
            inOrderIndexMap[inOrder[i]] = i;
        }

        getPostOrder(1, n, 1, n);

        System.out.print(sb);
    }

    public static void getPostOrder(int preStart, int preEnd, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) {
            return;
        }

        int root = preOrder[preStart];

        int rootIdx = inOrderIndexMap[root];
        int leftSize = rootIdx - inStart;

        getPostOrder(preStart + 1, preStart + leftSize, inStart, rootIdx - 1);

        getPostOrder(preStart + leftSize + 1, preEnd, rootIdx + 1, inEnd);

        sb.append(root).append(" ");
    }
}