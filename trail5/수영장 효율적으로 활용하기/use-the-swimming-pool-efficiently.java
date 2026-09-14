import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] t;

    public static boolean isPossible(int limit) {
        int count = 1;
        int cur = 0;
        for(int i = 0; i < n; i++) {
            if(t[i] > limit) return false;
            
            if(cur + t[i] > limit) {
                count++;
                cur = t[i];
            } else {
                cur += t[i];
            }
        }
        return count <= m;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = new int[n];

        int totalSum = 0;
        int maxVal = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            t[i] = Integer.parseInt(st.nextToken());
            totalSum += t[i];
        }

        int answer = 0;
        int left = maxVal;
        int right = totalSum;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(isPossible(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.print(answer);
    }
}