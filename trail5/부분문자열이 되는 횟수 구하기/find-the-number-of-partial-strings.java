import java.util.*;
import java.io.*;

public class Main {
    public static char[] a, b;
    public static int[] order;

    public static boolean isPossible(int mid) {
        boolean[] deleted = new boolean[a.length];

        for(int t = 1; t <= mid; t++) {
            deleted[order[t] - 1] = true;
        }

        int j = 0;

        for(int i = 0; i < b.length; i++) {
            while(j < a.length && (deleted[j] || a[j] != b[i])) {
                j++;
            }
            if(j == a.length) return false;
            j++;
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();

        order = new int[a.length + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        order[0] = -1;
        for(int i = 1; i <= a.length; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        int answer = -1;
        int left = 0;
        int right = a.length;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(isPossible(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.print(answer + 1);
    }
}