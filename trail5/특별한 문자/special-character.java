import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        HashMap<Character, Integer> m = new LinkedHashMap<>();

        for(char ch : arr) {
            m.put(ch, m.getOrDefault(ch, 0) + 1);
        }

        boolean isTrue = true;

        for(char ch : m.keySet()) {
            int num = m.get(ch);

            if(num == 1) {
                System.out.print(ch);
                isTrue = false;
                break;
            }
        }
        if(isTrue) System.out.print("None");
    }
}