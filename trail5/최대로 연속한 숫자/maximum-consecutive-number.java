import java.util.*;
import java.io.*;

public class Main {

    public static void add(TreeMap<Integer, Integer> length, int n) {
        if(n <= 0) return;
        length.put(n, length.getOrDefault(n, 0) + 1);
    }

    public static void remove(TreeMap<Integer, Integer> length, int n) {
        if(n <= 0) return;

        int cnt = length.get(n);

        if(cnt == 1) length.remove(n);
        else length.put(n, cnt - 1);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        TreeSet<Integer> removed = new TreeSet<>();
        TreeMap<Integer, Integer> length = new TreeMap<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        removed.add(-1);
        removed.add(n + 1);

        add(length, n + 1);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            int left = removed.lower(num);
            int right = removed.higher(num);

            int old = right - left - 1;
            remove(length, old);

            add(length, right - num - 1);
            add(length, num - left - 1);

            removed.add(num);

            if(length.isEmpty()) sb.append(0).append("\n");
            else sb.append(length.lastKey()).append("\n");
        }
        System.out.print(sb);
    }
}