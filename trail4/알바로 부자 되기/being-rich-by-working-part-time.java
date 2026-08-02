import java.util.*;
import java.io.*;

class Job {
    int s, e, p;

    public Job(int s, int e, int p) {
        this.s = s;
        this.e = e;
        this.p = p;
    }
}

public class Main {
    public static int n;
    public static Job[] jobs = new Job[1000];
    public static int[] dp = new int[1000];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            jobs[i] = new Job(s, e, p);
            dp[i] = p;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {

                if(jobs[i].s > jobs[j].e) {
                    dp[i] = Math.max(dp[i], dp[j] + jobs[i].p);
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.print(ans);
    }
}