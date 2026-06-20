import java.io.*;
import java.util.*;

public class Main {
    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < 19 && y >= 0 && y < 19);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] grid = new int[19][19];

        int[] dx = new int[]{0, 1, 1, -1};
        int[] dy = new int[]{1, 0, 1, 1};

        for(int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 19; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int win = 0;
        int ax = 0;
        int ay = 0;

        for(int x = 0; x < 19; x++) {
            for(int y = 0; y < 19; y++) {
                int color = grid[x][y]; // 시작점 색
                
                if(color == 0) continue; // 돌이 없으면 패스

                for(int dir = 0; dir < 4; dir++) {
                    boolean isTrue = true;

                    for(int i = 1; i <= 4; i++) {
                        int nx = x + dx[dir] * i;
                        int ny = y + dy[dir] * i;

                        if(!inRange(nx, ny) || grid[nx][ny] != color) {
                            isTrue = false;
                            break;
                        }
                    }

                    if(isTrue) {
                        int prevX = x - dx[dir]; // 시작점의 바로 이전 칸
                        int prevY = y - dy[dir];
                        int nextX = x + dx[dir] * 5; // 5번째 돌의 바로 다음 칸
                        int nextY = y + dy[dir] * 5;

                        if(inRange(prevX, prevY) && grid[prevX][prevY] == color) isTrue = false;
                        if(inRange(nextX, nextY) && grid[nextX][nextY] == color) isTrue = false;
                    }

                    if(isTrue) {
                        win = color;
                        ax = x + 1 + dx[dir] * 2; 
                        ay = y + 1 + dy[dir] * 2;
                    }
                }
            }
        }
        
        System.out.println(win);
        
        if(win != 0) {
            System.out.println(ax + " " + ay);
        }
    }
}