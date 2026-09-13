import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] pos = new int[100000];
    public static int[] speed = new int[100000];

    public static boolean isPossible(double t) {
        double maxLeft = -Double.MAX_VALUE;
        double minRight = Double.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            double curLeft = pos[i] - speed[i] * t;
            double curRight = pos[i] + speed[i] * t;

            maxLeft = Math.max(maxLeft, curLeft);
            minRight = Math.min(minRight, curRight);
        }

        return maxLeft <= minRight;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            pos[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            speed[i] = Integer.parseInt(st.nextToken());
        }

        double answer = Integer.MAX_VALUE;
        double left = 0;
        double right = 1000000000;
        for(int i = 0; i < 100; i++) {
            double mid = (left + right) / 2;
            if(isPossible(mid)) {
                answer = mid;
                right = mid;
            } else {
                left = mid;
            }
        }
        System.out.printf("%.4f", answer);
    }
}