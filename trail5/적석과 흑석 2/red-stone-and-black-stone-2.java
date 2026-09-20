import java.util.*;
import java.io.*;

class Black implements Comparable<Black>{
    int s, e;

    public Black(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Black b) {
        return this.s - b.s;
    }
}

public class Main {
    public static int c, n;
    public static int[] red;
    public static Black[] black;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        red = new int[c];
        black = new Black[n];

        for(int i = 0; i < c; i++) {
            red[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            black[i] = new Black(s, e);
        }

        Arrays.sort(red);
        Arrays.sort(black);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int answer = 0;
        int bIdx = 0;
        for(int i = 0; i < c; i++) {
            int num = red[i];

            while(bIdx < n && black[bIdx].s <= num) {
                pq.add(black[bIdx].e);
                bIdx++;
            }

            while(!pq.isEmpty()) {
                int cur = pq.poll();
                if(cur >= num) {
                    answer++;
                    break;
                }
            }
        }

        System.out.print(answer);
    }
}