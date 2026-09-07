import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static int[] arr = new int[100001];

    public static HashMap<Integer, Integer> count = new HashMap<>();

    public static boolean canGo(int j) {
        if(j + 1 > n) return false;

        if(count.getOrDefault(arr[j + 1], 0) + 1 > k) return false;
        
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int j = 0;
        for(int i = 1; i <= n; i++) {
            while(canGo(j)) {
                count.put(arr[j + 1], count.getOrDefault(arr[j + 1], 0) + 1);
                j++;
            }

            ans = Math.max(ans, j - i + 1);
            count.put(arr[i], count.getOrDefault(arr[i], 1) - 1);
        }
        System.out.print(ans);
    }
}