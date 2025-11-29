package boj.backtracking.b1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int r, c;
    static boolean[] visited = new boolean[26];
    static int[][] board;
    static int max = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static int toIndex(char c) {
        if (c <= 'Z' && c >= 'A') {
            return c - 'A';
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new int[r][c];

        for (int i = 0; i < r; i++) {
            String n = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = toIndex(n.charAt(j));
            }
        }
        Arrays.fill(visited, false);
        visited[board[0][0]] = true;
        find_max(0, 0, 1);

        System.out.println(max);
    }

    public static void find_max(int x, int y, int count){
        max = Math.max(max, count);

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;

            if (!visited[board[nx][ny]]) {
                visited[board[nx][ny]] = true;
                find_max(nx, ny, count + 1);
                visited[board[nx][ny]] = false;
            }
        }
    }
}
