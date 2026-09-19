import java.util.*;
import java.io.*;

class Bomb implements Comparable<Bomb>{
    int v, t;

    public Bomb(int v, int t) {
        this.v = v;
        this.t = t;
    }

    @Override
    public int compareTo(Bomb b) {
        return b.v - this.v;
    }
}

public class Main {
    public static int n;
    public static Bomb[] bombs;
    public static boolean[] used = new boolean[10001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        bombs = new Bomb[n];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            bombs[i] = new Bomb(v, t);
        }

        Arrays.sort(bombs);

        int answer = 0;
        for(int i = 0; i < n; i++) {
            Bomb b = bombs[i];

            int curTime = b.t;
            while(curTime > 0) {
                if(!used[curTime]) {
                    used[curTime] = true;
                    answer += b.v;
                    break;
                }
                curTime--;
            }
        }
        System.out.print(answer);
    }
}