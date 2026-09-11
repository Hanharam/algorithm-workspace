import java.util.*;
import java.io.*;

class Line implements Comparable<Line>{
    long s, e;

    public Line(long s, long e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Line l) {
        return Long.compare(this.s, l.s);
    }
}

public class Main {
    public static int n, m;
    public static Line[] lines;

    public static boolean isPossible(long mid) {
        int count = 1;
        long last = lines[0].s;

        for(int i = 0; i < m; i++) {
            long s = lines[i].s;
            long e = lines[i].e;

            long nextPos = Math.max(last + mid, s);

            if(nextPos <= e) {
                long canPlace = (e - nextPos) / mid + 1;
                count += canPlace;

                last = nextPos + (canPlace - 1) * mid;
            }

            if(count >= n) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lines = new Line[m];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            long s = Long.parseLong(st.nextToken());
            long e = Long.parseLong(st.nextToken());

            lines[i] = new Line(s, e);
        }

        Arrays.sort(lines);

        long answer = 0;
        long left = 1;
        long right = lines[m - 1].e - lines[0].s;
        while(left <= right) {
            long mid = (left + right) / 2;

            if(isPossible(mid)) {
                answer = mid;
                left = mid + 1;
        } else {
                right = mid - 1;
            }
        }

        System.out.print(answer);
    }
}