import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = (" " + br.readLine()).toCharArray();
        int n = arr.length - 1;

        HashSet<Character> duplicate = new HashSet<>();

        int ans = 0;
        int j = 0;
        for(int i = 1; i <= n; i++) {
            while(j + 1 <= n && !duplicate.contains(arr[j + 1])) {
                duplicate.add(arr[j + 1]);
                j++;
            }

            ans = Math.max(ans, j - i + 1);
            duplicate.remove(arr[i]);
        }
        System.out.print(ans);
    }
}