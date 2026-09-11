import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair>{
    int s, e;

    public Pair(int s, int e){
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Pair p) {
        if(s != p.s) return s - p.s;
        return e - p.e;
    }
}

public class Main {
    public static int n;
    public static Pair[] pairs;

    public static boolean isPossible(int dist) {
        int last = pairs[0].s;

        // System.out.println("Dist = " + dist);

        for(int i = 1; i < n; i++) {
            int s = pairs[i].s;
            int e = pairs[i].e;

            int nextPos = Math.max(last + dist, s);
            
            // System.out.printf("NextPos = %d, Index = %d, S = %d, E = %d\n", nextPos, i, s, e);
            
            if(nextPos > e) return false;
            last = nextPos;
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        pairs = new Pair[n];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            pairs[i] = new Pair(s, e);
        }

        Arrays.sort(pairs);

        int answer = 0;
        int left = 1;
        int right = pairs[n - 1].e - pairs[0].s;

        while(left <= right) {
            int mid = (left + right) / 2;

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