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

        int[] seat = new int[n];

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

        PriorityQueue<Integer> segs = new PriorityQueue<>();
        HashMap<Integer, Integer> mapper = new HashMap<>();

        for(int i = 1; i <= n; i++) {
            segs.add(i);
        }

        for(int i = 0; i < points.size(); i++) {
            int index = points.get(i).index;
            
            if(points.get(i).v == 1) {
                int seatNum = segs.poll();
                mapper.put(index, seatNum);
                seat[index] = seatNum;
                // System.out.printf("[IN] Time: %d, Index: %d, Seat: %d\n", points.get(i).x, index, seatNum);
            } else {
                segs.add(seat[index]);
                // System.out.printf("[OUT] Time: %d, Index: %d, Seat: %d\n", points.get(i).x, index, mapper.get(index));
            }
        }

        for(int num : seat) {
            System.out.print(num + " ");
        }
    }
}