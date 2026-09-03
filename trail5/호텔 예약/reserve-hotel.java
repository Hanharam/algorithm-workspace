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
        if(x != p.x) return x - p.x;
        if(v != p.v) return p.v - v;
        return index - p.index;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Point> points = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            points.add(new Point(s, 1, i));
            points.add(new Point(e, -1, i));
        }

        Collections.sort(points);

        HashSet<Integer> segs = new HashSet<>();

        int ans = 0;
        for(int i = 0; i < points.size(); i++) {
            int index = points.get(i).index;
            
            if(points.get(i).v == 1) {
                segs.add(index);
                ans = Math.max(ans, segs.size());
            } else {
                segs.remove(index);
            }
        }
        System.out.print(ans);
    }
}