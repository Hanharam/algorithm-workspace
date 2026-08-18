import java.io.*;
import java.util.*;

public class Main {
    public static int n;

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> m = new HashMap<>();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(!m.containsKey(x)) m.put(x, y);
            else if(m.get(x) > y) m.put(x, y);
        }

        long ans = 0;
        for(int key : m.keySet()) {
            ans += m.get(key);
        }
        System.out.print(ans);
    }
}