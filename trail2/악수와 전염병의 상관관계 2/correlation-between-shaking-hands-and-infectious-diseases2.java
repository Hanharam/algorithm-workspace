import java.io.*;
import java.util.*;

class Shake implements Comparable<Shake> {
    int time;
    int person1;
    int person2;

    public Shake(int t, int x, int y) {
        this.time = t;
        this.person1 = x;
        this.person2 = y;
    }

    @Override
    public int compareTo(Shake shake){
        return time - shake.time;
    }
}

public class Main {
    public static final int MAX_T = 250;
    public static final int MAX_N = 100;

    public static int n, k, p, t;
    public static int[] shakeNum = new int[MAX_N + 1];
    public static boolean[] infected = new boolean[MAX_N + 1];

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        infected[p] = true;

        Shake[] shakes = new Shake[MAX_T];

        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int person1 = Integer.parseInt(st.nextToken());
            int person2 = Integer.parseInt(st.nextToken());
            shakes[i] = new Shake(time, person1, person2);
        }
        Arrays.sort(shakes, 0, t);

        for(int i = 0; i < t; i++) {
            int target1 = shakes[i].person1;
            int target2 = shakes[i].person2;

            if(infected[target1]) shakeNum[target1]++;
            if(infected[target2]) shakeNum[target2]++;

            if(infected[target1] && shakeNum[target1] <= k)
                infected[target2] = true;
            if(infected[target2] && shakeNum[target2] <= k)
                infected[target1] = true;
        }

        for(int i = 1; i <= n; i++) {
            if(infected[i]) System.out.print(1);
            else System.out.print(0);
        }
    }
}