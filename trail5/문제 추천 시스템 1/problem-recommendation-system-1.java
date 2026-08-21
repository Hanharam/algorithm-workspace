import java.util.*;
import java.io.*;

class Problem implements Comparable<Problem>{
    int p, l;

    public Problem(int p, int l) {
        this.p = p;
        this.l = l;
    }

    @Override
    public int compareTo(Problem o) {
        if(l == o.l) return p - o.p;
        return l - o.l;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeSet<Problem> s = new TreeSet<>();
        StringTokenizer st;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            s.add(new Problem(p, l));
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("rc")) {
                int x = Integer.parseInt(st.nextToken());
                if(x == 1) {
                    System.out.println(s.last().p);
                }
                else if(x == -1) {
                    System.out.println(s.first().p);
                }
            }
            else if(command.equals("ad")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());

                s.add(new Problem(p, l));
            }
            else if(command.equals("sv")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());

                s.remove(new Problem(p, l));
            }
        }
    }
}