import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> bomb = new HashMap<>();

        int ans = -1;
        for(int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());

            if(bomb.containsKey(num)) {
                int index = bomb.get(num);

                if(i - index <= k) ans = Math.max(ans, num);
            }
            bomb.put(num, i);
        }
        System.out.print(ans);
    }
}