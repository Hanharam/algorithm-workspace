import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        TreeSet<Integer> s = new TreeSet<>();

        for(int i = 1; i <= m; i++) {
            s.add(i);
        }

        int ans = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            Integer seat = s.floor(num);

            if (seat == null) {
                break;
            }

            s.remove(seat);
            ans++;
        }
        System.out.print(ans);
    }
}