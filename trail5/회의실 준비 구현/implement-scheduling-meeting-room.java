import java.util.*;
import java.io.*;

class Meeting implements Comparable<Meeting>{
    int s, e;

    public Meeting(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Meeting m) {
        if(this.e != m.e) return this.e - m.e;
        return this.s - m.s;
    }
}

public class Main {
    public static int n;
    public static Meeting[] meet;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        meet = new Meeting[n]; 

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            meet[i] = new Meeting(s, e);
        }

        Arrays.sort(meet);

        int answer = 0;
        int curTime = 0;
        for(int i = 0; i < n; i++) {
            int s = meet[i].s;
            int e = meet[i].e;

            if(curTime <= s) {
                curTime = e;
                answer++;
            }
        }

        System.out.print(answer);
    }
}