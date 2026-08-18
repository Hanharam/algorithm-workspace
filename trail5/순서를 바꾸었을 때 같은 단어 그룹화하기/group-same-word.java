import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static HashMap<String, Integer> m = new HashMap<>();

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int ans = 0;

        for(int i = 0; i < n; i++) {
            char[] arr = br.readLine().toCharArray();
            Arrays.sort(arr);

            String key = new String(arr);

            m.put(key, m.getOrDefault(key, 0) + 1);
            ans = Math.max(ans, m.get(key));

        }

        System.out.print(ans);
    }
}