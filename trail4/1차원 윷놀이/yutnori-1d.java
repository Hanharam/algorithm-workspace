import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, k;

    public static int[] dist;
    public static int[] horses;

    public static int answer;

    public static void calc() {
        int score = 0;

        for(int i = 0; i < k; i++) {
            if(horses[i] >= m) {
                score++;
            }
        }

        answer = Math.max(score, answer);
    }

    public static void choose(int cnt) {
        if(cnt == n) {
            calc();
            return;
        }

        for(int i = 0; i < k; i++) {
            horses[i] += dist[cnt];
            choose(cnt + 1);
            horses[i] -= dist[cnt];
        }

        return;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dist = new int[n];
        horses = new int[k];

        Arrays.fill(horses, 1);

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }


        choose(0);

        System.out.print(answer);
    }
}