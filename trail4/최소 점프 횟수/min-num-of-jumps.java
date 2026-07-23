import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] board;

    public static int jump = Integer.MAX_VALUE;

    public static void choose(int cnt, int idx) {
        if(idx == n) {
            jump = Math.min(jump, cnt - 1);
            return;
        }
        if(cnt == n + 1 || idx > n) {
            return;
        }

        for(int i = 1; i <= board[idx]; i++) {
            choose(cnt + 1, idx + i);
        }
        return;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        choose(1, 1);

        if(jump == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.print(jump);
    }
}