import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String t = st.nextToken();

        String[] words = new String[n];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            String wrd = br.readLine();

            if (wrd.startsWith(t)) {
                words[idx++] = wrd;
            }
        }

        String[] validWords = Arrays.copyOfRange(words, 0, idx);

        Arrays.sort(validWords);

        System.out.print(validWords[k - 1]);
    }
}