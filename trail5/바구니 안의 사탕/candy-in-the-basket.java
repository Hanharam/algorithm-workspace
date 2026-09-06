import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
    int x, val;

    public Point(int x, int val) {
        this.x = x;
        this.val = val;
    }

    @Override
    public int compareTo(Point p) {
        if(this.x != p.x) return x - p.x;
        return val - p.val;
    }
}

public class Main {
    public static int n, k;
    public static int[] basket = new int[1000001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int val = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            basket[x] += val;
        }

        long ans = 0;

        int j = 0;
        long sum = 0;
        for(int i = 0; i < 1000001; i++) {
            while(j <= i + 2 * k && j < 1000001) {
                sum += basket[j];
                j++;
            }

            ans = Math.max(ans, sum);
            sum -= basket[i];
        }
        System.out.print(ans);
    }
}