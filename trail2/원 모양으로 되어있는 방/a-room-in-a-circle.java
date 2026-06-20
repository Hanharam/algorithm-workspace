import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] rooms = new int[n];

        for(int i = 0; i < n; i++) {
            rooms[i] = Integer.parseInt(br.readLine());
        }

        int minDist = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            int curDist = 0;
            for(int j = 0; j < n; j++) {
                curDist += rooms[ (i + j) % n ] * j; 
            }

            minDist = Math.min(curDist, minDist);
        }
        System.out.print(minDist);
    }
}