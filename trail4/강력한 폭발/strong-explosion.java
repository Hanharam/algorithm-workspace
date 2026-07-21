import java.io.*;
import java.util.*;

class Bomb{
    int x, y;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n;
    public static int[][] grid;
    public static int[][] temp;

    public static int maxCount = Integer.MIN_VALUE;

    public static int[][] bombX = new int[3][4];
    public static int[][] bombY = new int[3][4];

    public static ArrayList<Bomb> bombs = new ArrayList<>();

    public static void printArray() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static void explode(int x, int y, int type) {
        grid[x][y] = 1;
        for(int i = 0; i < 4; i++) {
            int nx = x + bombX[type][i];
            int ny = y + bombY[type][i];

            if(inRange(nx, ny)) {
                grid[nx][ny]++;
            }
        }
    }

    public static void restore(int x, int y, int type) {
        for(int i = 0; i < 4; i++) {
            int nx = x + bombX[type][i];
            int ny = y + bombY[type][i];

            if(inRange(nx, ny)) {
                grid[nx][ny]--;
            }
        }
    }

    public static int countBomb() {
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] >= 1) {
                    cnt++;
                }
            }
        }
        
        return cnt;
    }

    public static void maxCount(int curNum) {
        if(curNum == bombs.size()) {
            int cnt = countBomb();
            maxCount = Math.max(maxCount, cnt);
            return;
        }

        Bomb bomb = bombs.get(curNum);
        int x = bomb.x;
        int y = bomb.y;

        for(int type = 0; type < 3; type++) {
            explode(x, y, type);
            maxCount(curNum + 1);
            restore(x, y, type);
        }
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];

        bombX[0] = new int[]{-1, -2, 1, 2};
        bombY[0] = new int[]{0, 0, 0, 0};
        bombX[1] = new int[]{1, 0, -1, 0};
        bombY[1] = new int[]{0, 1, 0, -1};
        bombX[2] = new int[]{1, 1, -1, -1};
        bombY[2] = new int[]{1, -1, 1, -1};

        StringTokenizer st;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                grid[i][j] = num;

                if(num == 1) {
                    bombs.add(new Bomb(i, j));
                }
            }
        }

        maxCount(0);

        System.out.print(maxCount);
    }
}