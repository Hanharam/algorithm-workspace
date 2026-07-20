import java.io.*;
import java.util.*;

class Node {
    int x, y;
    final int weight;
    final int dir;
    final int num;

    Node(int x, int y, int weight, int dir, int num) {
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.dir = dir;
        this.num = num;
    }
}

public class Main {
    static final int BLANK = -1;
    static final int ASCII_NUM = 128;

    static final int COORD_SIZE = 4000;
    static final int OFFSET = 2000;

    static int T, N;
    static int currTime;
    static int lastCollisionTime;

    static final int[] mapper = new int[ASCII_NUM];

    // U, D, L, R
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    static ArrayList<Node> marbles = new ArrayList<>();
    static ArrayList<Node> nextMarbles = new ArrayList<>();

    static final int[][] nextMarbleIndex =
            new int[COORD_SIZE + 1][COORD_SIZE + 1];

    public static boolean outOfMap(Node marble) {
        return marble.x < 0 || marble.x > COORD_SIZE || marble.y < 0 || marble.y > COORD_SIZE;
    }

    public static boolean isStronger(Node first, Node second) {
        if(first.weight != second.weight) {
            return first.weight > second.weight;
        }
        return first.num > second.num;
    }

    public static Node collide(Node first, Node second) {
        if(isStronger(first, second)) {
            return first;
        }
        return second;
    }

    public static void pushNextMarble(Node marble) {
        if(outOfMap(marble)) {
            return;
        }

        int x = marble.x;
        int y = marble.y;
        int index = nextMarbleIndex[y][x];

        // 현재 좌표에 먼저 도착한 구슬이 없는 경우
        if(index == BLANK) {
            nextMarbleIndex[y][x] = nextMarbles.size();
            nextMarbles.add(marble);
            return;
        }

        // 이미 다른 구슬이 있는 경우
        Node existing = nextMarbles.get(index);
        Node winner = collide(existing, marble);

        nextMarbles.set(index, winner);
        lastCollisionTime = currTime;
    }

    public static void simulate() {
        for(Node marble : marbles) {
            marble.x += dx[marble.dir];
            marble.y += dy[marble.dir];

            pushNextMarble(marble);
        }

        for(Node marble : nextMarbles) {
            nextMarbleIndex[marble.y][marble.x] = BLANK;
        }

        ArrayList<Node> temp = marbles;
        marbles = nextMarbles;
        nextMarbles = temp;

        nextMarbles.clear();
    }
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        mapper['U'] = 0;
        mapper['D'] = 1;
        mapper['L'] = 2;
        mapper['R'] = 3;

        for(int y = 0; y <= COORD_SIZE; y++) {
            Arrays.fill(nextMarbleIndex[y], BLANK);
        }

        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());

            marbles = new ArrayList<>(N);
            nextMarbles = new ArrayList<>(N);
            lastCollisionTime = -1;

            for(int num = 1; num <= N; num++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                char direction = st.nextToken().charAt(0);

                x = x * 2 + OFFSET;
                y = y * 2 + OFFSET;

                marbles.add(new Node(x, y, weight, mapper[direction], num));
            }

            for(int time = 1; time <= COORD_SIZE && marbles.size() > 1; time++) {
                currTime = time;
                simulate();
            }
            answer.append(lastCollisionTime).append('\n');
        }
        System.out.print(answer);

    }
}

