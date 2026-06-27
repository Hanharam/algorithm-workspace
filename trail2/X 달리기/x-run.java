import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int maxSpeed = (int) Math.sqrt(x);
        
        int maxPeakDistance = maxSpeed * maxSpeed;

        int minTime = 0;

        if (x == maxPeakDistance) {
            minTime = 2 * maxSpeed - 1;
        } else if (x <= maxPeakDistance + maxSpeed) {
            minTime = 2 * maxSpeed;
        } else {
            minTime = 2 * maxSpeed + 1;
        }

        System.out.println(minTime);
    }
}
