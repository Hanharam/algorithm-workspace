import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] arr;

    public static boolean inRange(int x) {
        return 0 <= x && x < n;
    }

    public static void flip(int idx) {
        if(!inRange(idx)) return;

        if(inRange(idx - 1)) arr[idx - 1] = (arr[idx - 1] + 1) % 2;
        arr[idx] = (arr[idx] + 1) % 2;
        if(inRange(idx + 1)) arr[idx + 1] = (arr[idx + 1] + 1) % 2;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        if(arr[0] == 0) {
            flip(1);
            ans++;
        }

        for(int i = 1; i < n - 1; i++) {
            if(arr[i] == 0) {
                flip(i + 1);
                ans++;
            }
        }

        if(arr[n - 1] == 0) System.out.print(-1);
        else System.out.print(ans);
    }
}