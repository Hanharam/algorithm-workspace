import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
    int x, v, index;

    public Point(int x, int v, int index) {
        this.x = x;
        this.v = v;
        this.index = index;
    }

    @Override
    public int compareTo(Point p) {
        if(x != p.x) return this.x - p.x;
        return p.v - this.v;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Point> points = new ArrayList<>();

        int cur = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);

            if(dir == 'R') {
                points.add(new Point(cur, 1, i));
                points.add(new Point(cur + m, -1, i));
                cur = cur + m;
            } else {
                points.add(new Point(cur - m, 1, i));
                points.add(new Point(cur, -1, i));
                cur = cur -m;
            }
        }

        Collections.sort(points);

        int ans = 0;
        int cnt = 0;

        HashSet<Integer> segs = new HashSet<>();
        int start = Integer.MIN_VALUE;
        for(int i = 0; i < points.size() - 1; i++) {
            
            cnt += points.get(i).v;

            if(cnt >= k) {
                ans += points.get(i + 1).x - points.get(i).x;
            }
        }
        System.out.print(ans);
    }
}