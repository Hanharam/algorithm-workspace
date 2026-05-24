import java.io.*;
import java.util.*;

class Point {
    int x, y;
    int number;

    public Point(int x, int y, int number) {
        this.x = x;
        this.y = y;
        this.number = number;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i + 1);
        }
        
        Arrays.sort(points, (a, b) -> (Math.abs(a.x) + Math.abs(a.y)) - (Math.abs(b.x) + Math.abs(b.y)));

        for(int i = 0; i < n; i++) {
            System.out.println(points[i].number);
        }
    }
}