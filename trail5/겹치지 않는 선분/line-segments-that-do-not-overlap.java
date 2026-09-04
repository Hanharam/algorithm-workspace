import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair>{
    int x1, x2;
    
    public Pair(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public int compareTo(Pair p) {
        return this.x1 - p.x1;
    }
}

public class Main {
    public static Pair[] lines;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];
        
        lines = new Pair[n];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            lines[i] = new Pair(x1, x2);
        }

        Arrays.sort(lines);

        prefixMax[0] = lines[0].x2;
        for(int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(lines[i].x2, prefixMax[i - 1]);
        }

        suffixMin[n - 1] = lines[n - 1].x2;
        for(int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], lines[i].x2);
        }

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(lines[i].x2 < prefixMax[i] || lines[i].x2 > suffixMin[i]) continue;

            cnt++;
        }

        System.out.print(cnt);
    }
}
