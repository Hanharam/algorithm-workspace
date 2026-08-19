import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeMap<String, Integer> m = new TreeMap<>();

        for(int i = 0; i < n; i++) {
            String word = br.readLine();
            m.put(word, m.getOrDefault(word, 0) + 1);
        }

        for(Map.Entry<String, Integer> ent : m.entrySet()) {
            int val = ent.getValue();
            double percentage = (double) val / n * 100;

            System.out.printf("%s %.4f\n", ent.getKey(), percentage);
        }
    }
}