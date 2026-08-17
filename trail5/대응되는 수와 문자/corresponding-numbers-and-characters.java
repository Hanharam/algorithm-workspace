import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> sti = new HashMap<>();
        HashMap<Integer, String> its = new HashMap<>();

        for(int i = 1; i <= n; i++) {
            String word = br.readLine();
            sti.put(word, i);
            its.put(i, word);
        }

        for(int i = 0; i < m; i++) {
            String input = br.readLine();

            if(Character.isDigit(input.charAt(0))) {
                int num = Integer.parseInt(input);
                System.out.println(its.get(num));
            }
            else System.out.println(sti.get(input));
        }
    }
}