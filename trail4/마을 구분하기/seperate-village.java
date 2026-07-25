import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_NUM = 25;
    public static int n, people;
    public static int[][] grid = new int[MAX_NUM][MAX_NUM];
    public static boolean[][] visited = new boolean[MAX_NUM][MAX_NUM];
    public static ArrayList<Integer> group = new ArrayList<>();

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static boolean canGo(int x, int y) {
        if(!inRange(x, y)) return false;
        if(grid[x][y] == 0 || visited[x][y]) return false;
        return true;
    }

    public static void DFS(int x, int y) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        people++;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(canGo(nx, ny)) {
                visited[nx][ny] = true;
                DFS(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(canGo(i, j)) {
                    visited[i][j] = true;
                    people = 0;
                    DFS(i, j);
                    group.add(people);
                }
            }
        }

        Collections.sort(group);

        int size = group.size();
        System.out.println(size);
        for(int i = 0; i < size; i++) {
            System.out.println(group.get(i));
        }
    }
}