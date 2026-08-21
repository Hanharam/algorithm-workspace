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
        if(x == p.x) return y - p.y;
        return x - p.x;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        TreeSet<Pair> s = new TreeSet<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            s.add(new Pair(x, y));
        }

        for(int i = 0; i < m; i++) {
            int k = Integer.parseInt(br.readLine());

            Pair ans = s.ceiling(new Pair(k, 0));

            if(ans != null) {
                sb.append(ans.x);
                sb.append(" ");
                sb.append(ans.y);
                sb.append("\n");
                s.remove(ans);
            }
            else sb.append("-1 -1\n");
        }

        System.out.print(sb);
    }
}