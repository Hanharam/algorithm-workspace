import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) - 1;
        String t = st.nextToken();

        String[] words = new String[n];
        int idx = 0;

        for(int i = 0; i < n; i++) {
            String wrd = br.readLine();

            if(startWith(t, wrd)) words[idx++] = wrd;
        }

        Arrays.sort(words, 0, idx);
        System.out.print(words[k]);
    }

    public static boolean startWith(String t, String wrd) {
        if(t.length() > wrd.length()) return false;

        for(int i = 0; i < t.length(); i++) {
            if(t.charAt(i) != wrd.charAt(i)) return false;
        }

        return true;
    }
}