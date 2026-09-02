import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
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

        ArrayList<Point> points = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            points.add(new Point(x1, 1));
            points.add(new Point(x2, -1));
        }

        Collections.sort(points);

        int cnt = 0;
        int ans = 0;
        for(int i = 0; i < points.size() - 1; i++) {
            cnt += points.get(i).v;

            if(cnt > 0) ans += points.get(i + 1).x - points.get(i).x; 
        }
        System.out.print(ans);
    }
}