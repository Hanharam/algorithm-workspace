import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
    int x, v, y, index;

    public Point(int x, int v, int y, int index) {
        this.x = x;
        this.v = v;
        this.y = y;
        this.index = index;
    }

    @Override
    public int compareTo(Point p) {
        if(x != p.x) return this.x - p.x;
        return p.y - this.y;
    }
}

class Color implements Comparable<Color> {
    int index, y;

    public Color(int index, int y) {
        this.index = index;
        this.y = y;
    }

    @Override
    public int compareTo(Color c) {
        if(y != c.y) return this.y - c.y;
        return this.index - c.index;
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
            int y = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            points.add(new Point(x1, 1, y, i));
            points.add(new Point(x2, -1, y, i));
        }

        Collections.sort(points);

        TreeSet<Color> segs = new TreeSet<>();
        HashSet<Integer> ans = new HashSet<>();
        
        for(int i = 0; i < points.size(); i++) {
            int x = points.get(i).x;
            int y = points.get(i).y;
            int index = points.get(i).index;

            Color cur = new Color(index, y);
            
            if(points.get(i).v == 1) {
                segs.add(cur);

                if(segs.first().index == index) {
                    ans.add(index); 
                }
            } else {
                segs.remove(cur);

                if(segs.size() > 0) {
                    ans.add(segs.first().index);
                }
            }
        }
        System.out.print(ans.size());
    }
}