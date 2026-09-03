import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static ArrayList<Integer> ans = new ArrayList<>();

    public static void choose(int idx, int cnt) {
        if(cnt == m) {
            for(int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        if(idx > n) return;

        ans.add(idx);
        choose(idx + 1, cnt + 1);

        ans.remove(ans.size() - 1);
        choose(idx + 1, cnt);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        choose(1, 0);
    }
}