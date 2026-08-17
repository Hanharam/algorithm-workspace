import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();

            // i < j < 현재 위치가 되도록 관리
            for (int j = i + 1; j < n; j++) {
                int need = k - arr[i] - arr[j];

                ans += map.getOrDefault(need, 0);

                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            }
        }

        System.out.print(ans);
    }
}