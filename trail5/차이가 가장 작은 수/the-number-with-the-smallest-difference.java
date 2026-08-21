import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        TreeSet<Integer> s = new TreeSet<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            s.add(Integer.parseInt(br.readLine()));
        }

        int ans = Integer.MAX_VALUE;

        for(int num : s) {
            Integer x = s.ceiling(num + m);

            if(x != null) {
                ans = Math.min(ans, x - num);
            }
        }

        System.out.print(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
