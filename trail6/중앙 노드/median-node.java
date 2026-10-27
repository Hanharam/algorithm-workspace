import java.util.*;
import java.io.*;

public class Main {
    public static int n, r, central;
    public static ArrayList<Integer>[] tree;
    public static int[] count;
    public static boolean found = false;

    public static int calculateSize(int cur, int parent) {
        count[cur] = 1;

        for(int next : tree[cur]) {
            if(next == parent) continue;

            count[cur] += calculateSize(next, cur);
        }

        return count[cur];
    }

    public static void findCentral(int cur, int parent) {
        if(found) return;

        int childCount = 0;

        for(int next : tree[cur]) {
            if(next != parent) {
                childCount++;
            }
        }

        if(childCount >= 2) {
            found = true;
            central = cur;
            return;
        }

        if(childCount == 0) {
            central = cur;
            found = true;
            return;
        }

        for(int next : tree[cur]) {
            if(next != parent) {
                findCentral(next, cur);
                if(found) return;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        count = new int[n + 1];

        tree = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree[x].add(y);
            tree[y].add(x);
        }

        findCentral(r, 0);
        calculateSize(central, 0);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int child : tree[central]) {
            min = Math.min(min, count[child]);
            max = Math.max(max, count[child]);
        }

        System.out.print(max - min);
    }
}