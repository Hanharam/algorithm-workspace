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
        ArrayList<Point> points = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            segments[i] = new Segment(x1, x2);
        } 

        for(int i = 0; i < n; i++) {
            int x1 = segments[i].x1;
            int x2 = segments[i].x2;

            points.add(new Point(x1, 1));
            points.add(new Point(x2, -1));
        }

        Collections.sort(points);

        int ans = 0;
        int cnt = 0;
        for(int i = 0; i < points.size() - 1; i++) {
            cnt += points.get(i).v;
            ans = Math.max(ans, cnt);
        }
        System.out.print(ans);
    }
}