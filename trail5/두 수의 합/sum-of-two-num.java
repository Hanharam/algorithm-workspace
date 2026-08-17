import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> m = new HashMap<>();

        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(m.containsKey(k - num)) {
                cnt += m.get(k - num);
            }
            
            if(m.containsKey(num)) {
                int count = m.get(num);
                m.put(num, count + 1);
            }
            else m.put(num, 1);
        }

        System.out.print(cnt);
    }
}