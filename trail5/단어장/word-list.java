import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeMap<String, Integer> m = new TreeMap<>();

        for(int i = 0; i < n; i++) {
            String word = br.readLine();

            m.put(word, m.getOrDefault(word, 0) + 1);
        }

        for(Map.Entry<String, Integer> entry : m.entrySet()) {
            System.out.printf("%s %d\n", entry.getKey(), entry.getValue());
        }
    }
}