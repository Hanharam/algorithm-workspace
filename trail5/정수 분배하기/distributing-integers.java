import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] arr;

    public static boolean isPossible(int  k) {
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            cnt += (arr[i] / k);
        }
        if(cnt >= m) return true;
        else return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int maxIdx = 0;

        int left = 1;
        int right = 100000;
        while(left <= right) {
            int mid = (left + right) / 2;

            if(isPossible(mid)) {
                maxIdx = Math.max(maxIdx, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.print(maxIdx);
    }
}