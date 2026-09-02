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
        return this.x - p.x;
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
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            points.add(new Point(x1, 1, i));
            points.add(new Point(x2, -1, i));
        }

        Collections.sort(points);

        HashSet<Integer> segs = new HashSet<>();

        int ans = 0;

        int length = 0;
        for(int i = 0; i < points.size() - 1; i++) {
            int v = points.get(i).v;

            if(v == 1) {
                segs.add(points.get(i).index);
            } else {
                segs.remove(points.get(i).index);
            }

            if(segs.size() > 0) length += points.get(i + 1).x - points.get(i).x;
            else if(length > 0) {
                ans = Math.max(ans, length);
                length = 0;
            }
        }
        ans = Math.max(ans, length);

        System.out.print(ans);
    }
}