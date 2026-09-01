import java.util.*;
import java.io.*;

class Segment {
    int x1, x2;

    public Segment(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}

class Point implements Comparable<Point> {
    int x, v;

    public Point(int x, int v) {
        this.x = x;
        this.v = v;
    }

    @Override
    public int compareTo(Point p) {
        return this.x - p.x;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Segment[] segments = new Segment[n];
        Point[] points = new Point[2*n];
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            segments[i] = new Segment(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < n; i++) {
            points[2*i] = new Point(segments[i].x1, 1);
            points[2*i + 1] = new Point(segments[i].x2, -1);
        }
    
        Arrays.sort(points);

        int ans = 0;
        int cnt = 0;
        for(int i = 0; i < 2 * n; i++) {
            cnt += points[i].v;

            ans = Math.max(ans, cnt);
        }
        System.out.print(ans);
    }
}