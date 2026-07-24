import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static char[][] grid;

    public static int[] dx = {1, 0, -1, 0}; // D, R, U, L
    public static int[] dy = {0, 1, 0, -1};

    static class Node {
        int x, y, dist, coinCnt, lastCoinVal;

        public Node(int x, int y, int dist, int coinCnt, int lastCoinVal) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.coinCnt = coinCnt;
            this.lastCoinVal = lastCoinVal;
        }
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static int findMinPath(int x, int y) {
        Queue<Node> q = new LinkedList<>();

        boolean[][][][] visited = new boolean[n][n][4][10];

        q.offer(new Node(x, y, 0, 0, 0));
        visited[x][y][0][0] = true;

        while(!q.isEmpty()) {
            Node curr = q.poll();

            if(grid[curr.x][curr.y] == 'E' && curr.coinCnt >= 3) {
                return curr.dist;
            }

            for(int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if(!inRange(nx, ny)) continue;

                if(grid[nx][ny] >= '1' && grid[nx][ny] <= '9') {
                    int coinVal = grid[nx][ny] - '0';
                    if(curr.lastCoinVal < coinVal) {
                        int nextCoinCnt = Math.min(3, curr.coinCnt + 1);

                        if(!visited[nx][ny][nextCoinCnt][coinVal]) {
                            visited[nx][ny][nextCoinCnt][coinVal] = true;
                            q.offer(new Node(nx, ny, curr.dist + 1, nextCoinCnt, coinVal));
                        }
                    }
                }

                if(!visited[nx][ny][curr.coinCnt][curr.lastCoinVal]) {
                    visited[nx][ny][curr.coinCnt][curr.lastCoinVal] = true;
                    q.offer(new Node(nx, ny, curr.dist + 1, curr.coinCnt, curr.lastCoinVal));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        grid = new char[n][n];

        int startX = 0, startY = 0;

        for(int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
            }
        }
        System.out.print(findMinPath(startX, startY));
    }
}