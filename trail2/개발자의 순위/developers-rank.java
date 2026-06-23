import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] board = new int[k][n];

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for(int p1 = 1; p1 <= n; p1++) {
            for(int p2 = p1 + 1; p2 <= n; p2++) {
                boolean isTrue = true;
                int rank1 = 0;
                int rank2 = 0;
                int[] winner = new int[k];

                for(int i = 0; i < k; i++) {
                    for(int j = 0; j < n; j++) {
                        if(board[i][j] == p1) rank1 = j;
                        if(board[i][j] == p2) rank2 = j;
                    }
                    if(rank1 < rank2) winner[i] = 1;
                    else winner[i] = 2;
                }

                for(int i = 0; i < k - 1; i++) {
                    if(winner[i] != winner[i + 1]) isTrue = false;
                }
                if(isTrue) cnt++;
            }
        }
        System.out.print(cnt);
    }
}
