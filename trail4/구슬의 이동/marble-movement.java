import java.io.*;
import java.util.*;

class Marble {
    int num;
    int speed;
    int dir;

    public Marble(int num, int speed, int dir) {
        this.num = num;
        this.speed = speed;
        this.dir = dir;
    }
}

public class Main {
    public static final int MAX_N = 50;
    public static int n, m, t, k;
    public static int[] mapper = new int[128];

    public static int[] dx = {1, 0, 0, -1}; // D, R, L, U
    public static int[] dy = {0, 1, -1, 0};

    public static ArrayList<Marble>[][] marbles = new ArrayList[MAX_N][MAX_N];
    public static ArrayList<Marble>[][] temp = new ArrayList[MAX_N][MAX_N];

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static void moveAll() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {    // 좌표 돌면서 구슬 찾기

                for(int q = 0; q < marbles[i][j].size(); q++) {  // 해당 칸에 있는 모든 구슬들
                    int x = i;
                    int y = j;
                    int nx = -1, ny = -1;

                    Marble marble = marbles[i][j].get(q);
                    int speed = marble.speed;

                    while(speed-- > 0) {  // speed 만큼 전진
                        nx = x + dx[marble.dir];
                        ny = y + dy[marble.dir];

                        if(inRange(nx, ny)) {   // 범위 내에 있으면 전진
                            x = nx;
                            y = ny;
                        }
                        else {  // 범위 밖으로 나가면 반대 방향으로 전진
                            marble.dir = 3 - marble.dir;
                            x += dx[marble.dir];
                            y += dy[marble.dir];
                        }
                    }

                    temp[x][y].add(marble);
                }
            }
        }
    }

    public static boolean isDuplicate(int x, int y) {
        return temp[x][y].size() > k;
    }

    public static void removeDuplicate() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                if(isDuplicate(i, j)) {
                    while(temp[i][j].size() > k) {
                        int minSpeed = Integer.MAX_VALUE;
                        int minIdx = 0;
                        int minNum = Integer.MAX_VALUE;

                        for(int k = 0; k < temp[i][j].size(); k++) {
                            Marble marble = temp[i][j].get(k);

                            if(minSpeed > marble.speed) {
                                minSpeed = marble.speed;
                                minIdx = k;
                                minNum = marble.num;
                            }
                            else if(minSpeed == marble.speed && minNum > marble.num) {
                                minIdx = k;
                                minNum = marble.num;
                            }
                        }
                        temp[i][j].remove(minIdx);
                    }
                }
            }
        }
    }

    public static void simulate() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                temp[i][j] = new ArrayList<>();
            }
        }

        moveAll();

        removeDuplicate();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                marbles[i][j] = temp[i][j];
            }       
        }
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                marbles[i][j] = new ArrayList<>();
            }
        }

        mapper['D'] = 0;
        mapper['R'] = 1;
        mapper['L'] = 2;
        mapper['U'] = 3;

        int num = 0;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int dir = mapper[st.nextToken().charAt(0)];
            int speed = Integer.parseInt(st.nextToken());
            num++;
            marbles[x][y].add(new Marble(num, speed, dir));
        }

        for(int i = 0; i < t; i++) {
            simulate();
        }
        
        int ans = 0;
        for(int i = 0; i < n ; i++) {
            for(int j = 0; j < n; j++) {
                ans += marbles[i][j].size();
            }
        }
        System.out.print(ans);
    }
}

// for(int z = 0; z < n; z++) {
//     for(int c = 0; c < n; c++) {
//         System.out.print(temp[z][c].size() + " ");
//     }
//     System.out.println();
// }
// System.out.println();