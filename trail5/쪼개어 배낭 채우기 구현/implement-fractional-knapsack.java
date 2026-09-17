import java.util.*;
import java.io.*;

class Gem implements Comparable<Gem>{
    int w, p; 
    double v;

    public Gem(int w, int p) {
        this.w = w;
        this.p = p;
        this.v = (double) p / w;
    }

    @Override
    public int compareTo(Gem g) {
        return Double.compare(g.v, this.v);
    }
}

public class Main {
    public static int n, m;
    public static Gem[] gems;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        gems = new Gem[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            gems[i] = new Gem(w, p);
        }

        Arrays.sort(gems);

        double answer = 0;

        for(int i = 0; i < n; i++) {
            int w = gems[i].w;
            int p = gems[i].p;

            if(m >= w) {
                answer += p;
                m -= w;
            } else {
                answer += m * gems[i].v;
                break;
            }
        }
        System.out.printf("%.3f", answer);
    }
}