import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> m = new HashMap<>();

        int ans = 1;
        for(int i = 0; i < n; i++) {
            String word = br.readLine();

            if(m.containsKey(word)) {
                int cnt = m.get(word);
                m.put(word, cnt + 1);
                ans = Math.max(cnt + 1, ans);
            }
            else {
                m.put(word, 1);
            }
        }

        System.out.print(ans);
    }
}