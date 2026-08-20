import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        TreeSet<Integer> s = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n ; i++) {
            s.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < m; i++) {
            int x = Integer.parseInt(br.readLine());
            Integer result = s.ceiling(x);
            if(result == null) System.out.println(-1);
            else System.out.println(result);
        }
    }
}