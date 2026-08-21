import java.util.*;
import java.io.*;

class Tuple implements Comparable<Tuple> {
    int len, s, e;

    public Tuple(int len, int s, int e) {
        this.len = len;
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Tuple t) {
        if(len != t.len) return t.len - this.len;
        else if(s != t.s) return s - t.s;
        else return e - t.e;
    }
}

public class Main {
    public static int n, m;
    public static TreeSet<Integer> sNum = new TreeSet<>();
    public static TreeSet<Tuple> sLen = new TreeSet<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        sNum.add(-1);
        sNum.add(n + 1);

        sLen.add(new Tuple(n + 1, -1, n + 1));

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            sNum.add(num);


            int right = sNum.higher(num);
            int left = sNum.lower(num);

            sLen.remove(new Tuple(right - left - 1, left, right));
            sLen.add(new Tuple(right - num - 1, num, right));
            sLen.add(new Tuple(num - left - 1, left, num));

            System.out.println(sLen.first().len);
        }
    }
}