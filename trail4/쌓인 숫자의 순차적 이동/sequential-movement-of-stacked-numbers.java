import java.util.Scanner;
import java.util.ArrayList;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static final Pair OUT_OF_GRID = new Pair(-1, -1);
    public static final int DIR_NUM = 8;
    public static final int MAX_N = 20;

    public static int n, m;
    public static ArrayList<Integer>[][] grid = new ArrayList[MAX_N][MAX_N];

    public static Pair Getpos(int moveNum) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < grid[i][j].size(); k++) {
                    if(moveNum == grid[i][j].get(k))
                        return new Pair(i, j);
                }
            }
        }
        return new Pair(0, 0);
    }
    
    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static Pair NextPos(Pair pos) {
        int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
        int[] dy = {1, -1, 0, 1, -1, 0, 1, -1};

        int x = pos.x;
        int y = pos.y;

        int maxVal = -1;
        Pair maxPos = OUT_OF_GRID;
        for(int i = 0; i < DIR_NUM; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(inRange(nx, ny)) {
                for(int j = 0; j < (int) grid[nx][ny].size(); j++) {
                    if(maxVal < grid[nx][ny].get(j)) {
                        maxVal = grid[nx][ny].get(j);
                        maxPos = new Pair(nx, ny);
                    }
                }
            }
        }

        return maxPos;
    }

    public static void move(Pair pos, Pair nextPos, int moveNum) {
        int x = pos.x;
        int y = pos.y;

        int nx = nextPos.x;
        int ny = nextPos.y;

        boolean toMove = false;
        for(int i = 0; i < (int) grid[x][y].size(); i++) {
            if(grid[x][y].get(i) == moveNum)
                toMove = true;
            
            if(toMove)
                grid[nx][ny].add(grid[x][y].get(i));
        }

        while(grid[x][y].get(grid[x][y].size() - 1) != moveNum) {
            grid[x][y].remove(grid[x][y].size() - 1);
        }
        grid[x][y].remove(grid[x][y].size() - 1);
    }


    public static void simulate(int moveNum) {

        Pair pos = Getpos(moveNum);
        Pair nextPos = NextPos(pos);
        if(nextPos != OUT_OF_GRID)
            move(pos, nextPos, moveNum);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int num = sc.nextInt();
                grid[i][j].add(num);
            }
        }

        while(m-- > 0) {
            int moveNum = sc.nextInt();
            simulate(moveNum);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if((int) grid[i] [j].size() == 0) 
                    System.out.print("None");
                else {
                    for(int k = (int) grid[i][j].size() - 1; k >= 0; k--) {
                        System.out.print(grid[i][j].get(k) + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}