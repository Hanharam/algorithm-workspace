import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashSet<Integer> duplicate = new HashSet<>();
        int[] arr = new int[n + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int j = 0;
        for(int i = 1; i <= n; i++) {
            
            while(j + 1 <= n && !duplicate.contains(arr[j + 1])) {
                duplicate.add(arr[j + 1]);
                j++;
            }

            ans = Math.max(ans, j - i + 1);
            duplicate.remove(arr[i]);
        }

        System.out.print(ans);
    }
}