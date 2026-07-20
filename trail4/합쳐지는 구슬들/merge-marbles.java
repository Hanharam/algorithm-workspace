import java.io.*;
import java.util.*;

class Node {
    int x, y;
    int dir, weight, num;

    public Node(int x, int y, int dir, int weight, int num) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.weight = weight;
        this.num = num;
    }
}

public class Main {
    public static int n, m, t;
    
    public static final int ASCII_NUM = 128;
    public static final int MAX_NUM = 50;
    public static final int BLANK = -1;

    public static ArrayList<Node> marbles = new ArrayList<>();
    public static ArrayList<Node> nextMarbles = new ArrayList<>();
    public static int[][] nextMarblesIndex = new int[MAX_NUM][MAX_NUM];

    public static int[] dx = {1, 0, 0, -1}; // D, R, L, U
    public static int[] dy = {0, 1, -1, 0};

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static Node combine(Node m1, Node m2, int x, int y) {
        int weight = m1.weight + m2.weight;
        int dir, num;
        if(m1.num > m2.num) {
            dir = m1.dir;
            num = m1.num;
        }
        else {
            dir = m2.dir;
            num = m2.num;
        }

        return new Node(x, y, dir, weight, num);
    }

    public static void simulate() {
        for(Node marble : marbles) {
            int x = marble.x;
            int y = marble.y;

            int nx = x + dx[marble.dir];
            int ny = y + dy[marble.dir];

            if(!inRange(nx, ny)) {
                marble.dir = 3 - marble.dir;
                nx = x;
                ny = y;
            }

            if(nextMarblesIndex[nx][ny] == BLANK) {
                nextMarblesIndex[nx][ny] = nextMarbles.size();
                marble.x = nx;
                marble.y = ny;
                nextMarbles.add(marble);
            }
            else {
                int index = nextMarblesIndex[nx][ny];

                Node newMarble = combine(marble, nextMarbles.get(index), nx, ny);
                nextMarbles.set(index, newMarble);
            }
        }

        for(Node marble : nextMarbles) {
            nextMarblesIndex[marble.x][marble.y] = BLANK;
        }

        ArrayList<Node> temp = marbles;
        marbles = nextMarbles;
        nextMarbles = temp;

        nextMarbles.clear();
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        marbles = new ArrayList<>(n);
        nextMarbles = new ArrayList<>(n);

        int[] mapper = new int[ASCII_NUM];
        mapper['D'] = 0;
        mapper['R'] = 1;
        mapper['L'] = 2;
        mapper['U'] = 3;

        for(int num = 1; num <= m; num++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            char direction = st.nextToken().charAt(0);
            int weight = Integer.parseInt(st.nextToken());

            marbles.add(new Node(x, y, mapper[direction], weight, num));
        }

        for(int i = 0; i < n; i++) {
            Arrays.fill(nextMarblesIndex[i], BLANK);
        }

        while(t-- > 0) {
            simulate();
        }

        int num = marbles.size();
        int ans = 0;
        for(Node marble : marbles) {
            ans = Math.max(ans, marble.weight);
        }

        System.out.print(num + " " + ans);
    }
}