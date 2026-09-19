import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
    int num, cnt;

    public Point(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Point p) {
        return this.num - p.num;
    }
}

public class Main {
    public static int n, m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Point[] points = new Point[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            points[i] = new Point(num, cnt);
        }

        Arrays.sort(points);

        long answer = 0;
        int left = 0;
        int right = n - 1;

        while(left <= right) {
            if (left == right) {
                answer = Math.max(answer, (long)points[left].num * 2);
                break;
            }

            answer = Math.max(answer, points[left].num + points[right].num);

            int paired_cnt = Math.min(points[left].cnt , points[right].cnt);
            points[left].cnt -= paired_cnt;
            points[right].cnt -= paired_cnt;

            if(points[left].cnt == 0) left++;
            if(points[right].cnt == 0) right--;

        }
        System.out.print(answer);
    }
}