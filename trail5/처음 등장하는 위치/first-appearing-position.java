import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeMap<Integer, Integer> m = new TreeMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            int key = Integer.parseInt(st.nextToken());
            if(!m.containsKey(key)) m.put(key, i);
        }

        for(Map.Entry<Integer, Integer> entry : m.entrySet()) {
            System.out.printf("%d %d\n", entry.getKey(), entry.getValue());
        }
    }
}