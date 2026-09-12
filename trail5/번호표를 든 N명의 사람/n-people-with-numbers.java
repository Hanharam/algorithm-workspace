import java.util.*;
import java.io.*;

public class Main {
    public static int n, t;
    public static int[] order;

    public static boolean isPossible(int limit) {
        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int i = 1;
        do {
            
            while(pq.size() < limit && i <= n) {
                pq.add(time + order[i]);
                i++;
            }

            time = pq.poll();
        } while(!pq.isEmpty());

        if(time > t) return false;
        else return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        order = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            order[i] = Integer.parseInt(br.readLine());
        }

        int left = 1;
        int right = n;
        int answer = n;
        while(left <= right) {
            int mid = (left + right) / 2;

            if(isPossible(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.print(answer);
    }
}
// 먼저 나온 숫자를 더하면 됨