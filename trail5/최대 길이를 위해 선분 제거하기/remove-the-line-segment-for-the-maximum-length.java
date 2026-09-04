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
    public static ArrayList<Point> points = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            points.add(new Point(x1, 1, i));
            points.add(new Point(x2, -1, i));
        }

        Collections.sort(points);

        HashSet<Integer> segs = new HashSet<>();
        int[] only = new int[n];
        int total = 0;
        
        for(int i = 0; i < points.size() - 1; i++) {
            int index = points.get(i).index;

            if(points.get(i).v == 1) segs.add(index);
            else segs.remove(index);

            if(segs.size() == 1) {
                int idx = segs.iterator().next();
                only[idx] += points.get(i + 1).x - points.get(i).x;
            }

            if(segs.size() > 0) total += points.get(i + 1).x - points.get(i).x;
        }

        int min = Integer.MAX_VALUE;
        for(int num : only) { 
            min = Math.min(min, num);
        }

        System.out.print(total - min);
    }
}