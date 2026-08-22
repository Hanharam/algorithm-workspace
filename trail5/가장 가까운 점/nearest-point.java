import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair>{
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p) {
        if((x+y) != (p.x + p.y)) return (x + y) - (p.x + p.y);
        else if(x != p.x) return x - p.x;
        else return y - p.y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.add(new Pair(x, y));
        }

        for(int i = 0; i < m; i++) {
            Pair p = pq.poll();
            pq.add(new Pair(p.x + 2, p.y + 2));
        }

        Pair ans = pq.peek();
        System.out.printf("%d %d", ans.x, ans.y);
    }
}