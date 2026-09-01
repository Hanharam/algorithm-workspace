import java.util.*;
import java.io.*;

class Segment {
    int x1, x2;

    public Segment(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}

class Point implements Comparable<Point>{
    int x, v, index;
    
    public Point(int x, int v, int index) {
        this.x = x;
        this.v = v;
        this.index = index;
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
            segments[i] = new Segment(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < n; i++) {
            int x1 = segments[i].x1;
            int x2 = segments[i].x2;
            int index = i;

            points.add(new Point(x1, 1, index));
            points.add(new Point(x2, -1, index));
        }

        Collections.sort(points);

        HashSet<Integer> segs = new HashSet<Integer>();
        int ans = 0;
        for(int i = 0; i < points.size() - 1; i++) {
            
            if(points.get(i).v == 1) {
                if(segs.size() == 0) ans++;

                segs.add(points.get(i).index);
            } else {
                segs.remove(points.get(i).index);
            }
        }

        System.out.print(ans);
    }
}