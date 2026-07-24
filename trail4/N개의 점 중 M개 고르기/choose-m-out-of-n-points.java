import java.io.*;
import java.util.*;

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n, m;
    public static int ans = Integer.MAX_VALUE;

    public static ArrayList<Node> comb = new ArrayList<>();
    public static ArrayList<Node> selectedNode = new ArrayList<>();

    public static int getDist(Node a, Node b) {
        int x1 = a.x;
        int y1 = a.y;

        int x2 = b.x;
        int y2 = b.y;

        return (int) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static void calc() {
        int maxVal = Integer.MIN_VALUE;

        for(int i = 0; i < m; i++) {
            for(int j = i; j < m; j++) {
                maxVal = Math.max(maxVal, getDist(selectedNode.get(i), selectedNode.get(j)));
            }
        }
        ans = Math.min(ans, maxVal);
    }

    public static void findMinDist(int curNum, int curIdx) {
        if(curNum == m + 1) {
            calc();
            return;
        }

        if(curIdx == n && m - curNum > n - 1 - curIdx) return;

        for(int i = curIdx; i < n; i++) {
            selectedNode.add(comb.get(i));
            findMinDist(curNum + 1, i + 1);
            selectedNode.remove(selectedNode.size() - 1);
        }
        return;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            comb.add(new Node(x, y));
        }

        findMinDist(1, 0);

        System.out.print(ans);
    }
}