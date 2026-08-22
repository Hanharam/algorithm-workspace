import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> a = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;
        double sum = 0;
        double ans = 0;
        for(int i = a.size() - 1; i >= 0; i--) {
            cnt++;
            sum += (double)a.get(i);
            pq.add(a.get(i));
            
            if(cnt >= 2) {
                double total = sum - (double)pq.peek();
                int temp = cnt - 1;

                ans = Math.max(ans, total/temp);
            }
        }
        System.out.printf("%.2f", ans);
    }
}