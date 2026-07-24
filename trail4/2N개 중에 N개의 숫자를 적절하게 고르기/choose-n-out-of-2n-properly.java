import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] arr;

    public static ArrayList<Integer> g1 = new ArrayList<>();
    public static ArrayList<Integer> g2 = new ArrayList<>();

    public static int ans = Integer.MAX_VALUE;

    public static void calc() {
        int num1 = 0, num2 = 0;

        for(int i = 0; i < n; i++) {
            num1 += g1.get(i);
            num2 += g2.get(i);
        }

        ans = Math.min(ans, Math.abs(num1 - num2));
    }

    public static void choose(int curNum, int curIdx) {
        if(curNum == 2*n + 1) {
            calc();
            return;
        }

        if(g1.size() < n) {
            g1.add(arr[curIdx]);
            choose(curNum + 1, curIdx + 1);
            g1.remove(g1.size() - 1);
        }
        
        if(g2.size() < n) {
            g2.add(arr[curIdx]);
            choose(curNum + 1, curIdx + 1);
            g2.remove(g2.size() - 1);
        }
        return;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[2*n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2*n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        choose(1, 0);
        System.out.print(ans);
    }
}