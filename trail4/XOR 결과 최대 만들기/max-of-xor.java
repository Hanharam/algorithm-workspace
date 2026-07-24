import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[] numbers;
    public static int answer = Integer.MIN_VALUE;
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static void calc() {
        int curValue = 0;
        for(int i = 0; i < arr.size(); i++) {
            curValue = curValue ^ arr.get(i);
        }

        answer = Math.max(answer, curValue);
    }

    public static void choose(int curNum, int cnt) {
        if(curNum == m + 1) {
            calc();
            return;
        }
        if(cnt == n) return;

        for(int i = cnt; i < n; i++) {
            arr.add(numbers[i]);
            choose(curNum + 1, i + 1);
            arr.remove(arr.size() - 1);
        }
        return;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numbers = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        choose(1, 0);

        System.out.print(answer);
    }
}