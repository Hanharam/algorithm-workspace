import java.util.*;
import java.io.*;

class Council implements Comparable<Council>{
    int s, e;

    public Council(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Council c) {
        if(this.e != c.e) return this.e - c.e;
        return this.s - this.s;
    }
}

public class Main {
    public static int n;
    public static Council[] councils;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        councils = new Council[n];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            councils[i] = new Council(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(councils);

        int cnt = 0;
        int curTime = 0;
        for(int i = 0; i < n; i++) {
            if(curTime > councils[i].s) continue;

            curTime = councils[i].e;
            cnt++;
        }
        System.out.print(n - cnt);
    }
}