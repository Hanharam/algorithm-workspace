import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] arr = (" " + st.nextToken()).toCharArray();
        int k = Integer.parseInt(st.nextToken());

        int n = arr.length - 1;

        HashMap<Character, Integer> duplicate = new HashMap<>();

        int ans = 0;
        int j = 0;
        for(int i = 1; i <= n; i++) {
            while(j + 1 <= n) {
                if(!duplicate.containsKey(arr[j + 1]) && duplicate.size() == k) break;
                
                duplicate.put(arr[j + 1], duplicate.getOrDefault(arr[j + 1], 0) + 1);
                j++;
            }

            ans = Math.max(ans, j - i + 1);
            if(duplicate.get(arr[i]) <= 1) duplicate.remove(arr[i]);
            else duplicate.put(arr[i], duplicate.get(arr[i]) - 1);
        }
        System.out.print(ans);
    }
}