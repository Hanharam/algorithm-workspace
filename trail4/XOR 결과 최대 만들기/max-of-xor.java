import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_NUM = 20;

    public static int n, m;
    public static int[] numbers;

    public static int answer = Integer.MIN_VALUE;

    public static void findMaxXor(int currIdx, int cnt, int currVal) {
        if(cnt == m) {
            answer = Math.max(currVal, answer);
            return;
        }

        if(currIdx >= n || n - currIdx < m - cnt) return;

        findMaxXor(currIdx + 1, cnt, currVal);

        findMaxXor(currIdx + 1, cnt + 1, currVal ^ numbers[currIdx]);
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

        findMaxXor(0, 0, 0);

        System.out.print(answer);
    }
}