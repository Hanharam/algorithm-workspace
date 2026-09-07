import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair>{
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p) {
        if(x != p.x) return x - p.x;
        return y - p.y;
    }
}

class Target implements Comparable<Target> {
    int x, y;

    public Target(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Target t) {
        if(y != t.y) return y - t.y;
        return x - t.x;
    }
}

public class Main {
    public static int n , d;
    public static Pair[] pairs = new Pair[100001];
    public static TreeSet<Target> pointCount = new TreeSet<>();

    public static int getMin() {
        if(pointCount.isEmpty()) return 0;
        return pointCount.first().y;
    }

    public static int getMax() {
        if(pointCount.isEmpty()) return 0;
        return pointCount.last().y;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pairs[i] = new Pair(x, y);
        }

        Arrays.sort(pairs, 1, n + 1);

        int ans = Integer.MAX_VALUE;
        int j = 0;
        for(int i = 1; i < n; i++) {
            while(j + 1 <= n && getMax() - getMin() < d) {
                pointCount.add(new Target(pairs[j + 1].x, pairs[j + 1].y));
                j++;
            }

            if(getMax() - getMin() < d) break;

            ans = Math.min(ans, pairs[j].x - pairs[i].x);
            pointCount.remove(new Target(pairs[i].x, pairs[i].y));
        }
        if(ans == Integer.MAX_VALUE) ans = -1;
        System.out.print(ans);
    }
}