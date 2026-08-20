import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int minDist = Integer.MAX_VALUE;

        TreeSet<Integer> s = new TreeSet<>();
        s.add(0);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            s.add(num);

            Integer left = s.lower(num);
            Integer right = s.higher(num);

            if(left != null) minDist = Math.min(minDist, num - left);
            if(right != null) minDist = Math.min(minDist, right - num);

            System.out.println(minDist);
        }
    }
}