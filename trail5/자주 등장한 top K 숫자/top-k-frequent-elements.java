import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int cnt, num;

    public Pair(int cnt, int num) {
        this.cnt = cnt;
        this.num = num;
    }

    @Override
    public int compareTo(Pair b) {
        if(cnt != b.cnt) return cnt - b.cnt;
        return num - b.num;
    }
}

public class Main {
    public static final int MAX_N = 100000;

    public static int n, k;
    public static int[] arr = new int[MAX_N];
    public static HashMap<Integer, Integer> freq = new HashMap<>();
    public static ArrayList<Pair> v = new ArrayList<>();


    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }

        for(Integer key : freq.keySet()) {
            v.add(new Pair(freq.get(key), key));
        }

        Collections.sort(v);

        for(int i = (int)v.size() - 1; i >= (int)v.size() - k; i--)
            System.out.print(v.get(i).num + " ");

    }
}