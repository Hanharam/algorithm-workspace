import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair>{
    int x, y, value;

    public Pair(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public int compareTo(Pair p) {
        return value - p.value;
    }
}

public class Main {
    public static int n;
    public static int ans = Integer.MAX_VALUE;
    public static char[][] grid = new char[20][20];
    public static Pair start, end;

    public static ArrayList<Pair> coins = new ArrayList<Pair>();

    public static void choose(int idx, int dist, int cnt, int px, int py) {
        if(cnt == 3) {
            ans = Math.min(ans, dist + Math.abs(px - end.x) + Math.abs(py - end.y));
            return;
        }

        if(idx >= coins.size()) return;

        
        int x = coins.get(idx).x;
        int y = coins.get(idx).y;
        int curDist = dist + Math.abs(x - px) + Math.abs(y - py);
        choose(idx + 1, curDist, cnt + 1, x, y);

        choose(idx + 1, dist, cnt, px, py);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if('0' < grid[i][j] && grid[i][j] <= '9') coins.add(new Pair(i, j, grid[i][j] - '0'));
                else if(grid[i][j] == 'S') start = new Pair(i, j, 0);
                else if(grid[i][j] == 'E') end = new Pair(i, j, 0);
            }
        }

        Collections.sort(coins);

        choose(0, 0, 0, start.x, start.y);

        System.out.print(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}