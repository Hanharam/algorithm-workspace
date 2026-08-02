import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair other) {
        if(this.y == other.y) {
            return other.x - this.x;
        }
        return this.y - other.y;
    }
}

public class Main {
    public static int n;
    public static ArrayList<Pair> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            lines.add(new Pair(x, y));
        }

        Collections.sort(lines);

        int cnt = 1;
        int idx = 0;
        for(int i = 0; i < n; i++) {
            Pair line = lines.get(i);
            if(idx == 0) {
                idx = line.y;
            }
            else if(line.x > idx) {
                idx = line.y;
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}