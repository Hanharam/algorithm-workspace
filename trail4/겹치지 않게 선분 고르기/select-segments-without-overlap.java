import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int ans = Integer.MIN_VALUE;

    public static int[] left;
    public static int[] right;

    public static int[] count = new int[1001];

    public static boolean canAdd(int i) {
        for(int x = left[i]; x <= right[i]; x++) {
            if(count[x] > 0) return false;
        }
        return true;
    }

    public static void addLine(int i) {
        for(int x = left[i]; x <= right[i]; x++) {
            count[x]++;
        }
    }

    public static void restore(int i) {
        for(int x = left[i]; x <= right[i]; x++) {
            count[x]--;
        }
    }

    public static void countMax(int idx, int curNum) {
        ans = Math.max(ans, curNum);
            
        for(int i = idx; i < n; i++) {
            if(canAdd(i)) {
            addLine(i);
            countMax(i + 1, curNum + 1);
            restore(i);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        left = new int[n];
        right = new int[n];


        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            left[i] = Integer.parseInt(st.nextToken());
            right[i] = Integer.parseInt(st.nextToken());
        }

        countMax(0, 0);

        System.out.print(ans);
    }
}