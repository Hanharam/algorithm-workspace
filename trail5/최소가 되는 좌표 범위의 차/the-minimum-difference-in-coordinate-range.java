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
        if(x != p.x) return x - p.x;
        return y - p.y;
    }
}

public class Main {
    public static int n , d;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        Pair[] pairs = new Pair[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pairs[i] = new Pair(x, y);
        }

        Arrays.sort(pairs);

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int ans = Integer.MAX_VALUE;

        int i = 0;
        for(int j = 0; j < n; j++) {

            while(!maxDeque.isEmpty() && pairs[maxDeque.peekLast()].y <= pairs[j].y) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(j);

            while(!minDeque.isEmpty() && pairs[minDeque.peekLast()].y >= pairs[j].y) {
                minDeque.pollLast();
            }
            minDeque.addLast(j);

            while(!maxDeque.isEmpty() && !minDeque.isEmpty() && 
            pairs[maxDeque.peekFirst()].y - pairs[minDeque.peekFirst()].y >= d) {
                
                ans = Math.min(ans, pairs[j].x - pairs[i].x);

                if (minDeque.peekFirst() == i) {
                    minDeque.pollFirst();
                }

                if (maxDeque.peekFirst() == i) {
                    maxDeque.pollFirst();
                }
                i++;
            }
        }
        if(ans == Integer.MAX_VALUE) ans = -1;
        System.out.print(ans);
    }
}