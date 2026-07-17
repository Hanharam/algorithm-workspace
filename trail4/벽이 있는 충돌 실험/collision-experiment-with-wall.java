import java.util.*;
import java.io.*;

class Marble {
    int x, y, z;

    public Marble(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {
    public static final int ASCII_NUM = 128;
    public static final int MAX_N = 50;
    public static final int DIR_NUM = 4;

    public static int t, n, m;

    public static int[][] marbleCnt = new int[MAX_N + 1][MAX_N + 1];

    public static int[] mapper = new int[ASCII_NUM];

    public static int[] dx = new int[]{-1, 0, 0, 1};
    public static int[] dy = new int[]{0, 1, -1, 0};

    public static ArrayList<Marble> marbles = new ArrayList<>();

    public static boolean inRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= n;
    }

    public static Marble move(Marble marble) {
        int x = marble.x;
        int y = marble.y;
        int dir = marble.z;

        int nx = x + dx[dir], ny = y + dy[dir];

        if(inRange(nx, ny))
            return new Marble(nx, ny, dir);
        else 
            return new Marble(x, y, 3 - dir);
    }

    public static void moveAll() {
        for(int i = 0; i < marbles.size(); i++) {
            Marble nextMarble = move(marbles.get(i));
            marbles.set(i, nextMarble);
        }
    }

    public static boolean duplicateMarbleExist(int targetIdx) {
        int targetX = marbles.get(targetIdx).x;
        int targetY = marbles.get(targetIdx).y;

        return marbleCnt[targetX][targetY] >= 2;
    }

    public static void removeDuplicateMarbles() {
        ArrayList<Marble> tempVector = new ArrayList<>();

        for(int i = 0; i < marbles.size(); i++) {
            int x = marbles.get(i).x;
            int y = marbles.get(i).y;
            marbleCnt[x][y]++;
        }

        for(int i = 0; i < marbles.size(); i++) {
            if(!duplicateMarbleExist(i))
                tempVector.add(marbles.get(i));
        }

        for(int i = 0; i < marbles.size(); i++) {
            int x = marbles.get(i).x;
            int y = marbles.get(i).y;
            marbleCnt[x][y]--;
        }

        marbles = tempVector;
    }

    public static void simulate() {
        moveAll();

        removeDuplicateMarbles();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        mapper['U'] = 0;
        mapper['R'] = 1;
        mapper['L'] = 2;
        mapper['D'] = 3;

        t = sc.nextInt();

        while(t-- > 0) {
            
            marbles = new ArrayList<>();

            n = sc.nextInt();
            m = sc.nextInt();

            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                char d = sc.next().charAt(0);
                marbles.add(new Marble(x, y, mapper[d]));
            }
            // Please write your code here.

            for(int i = 1; i <= 2*n; i++) {
                simulate();
            }

            System.out.println(marbles.size());
        }
    }
}