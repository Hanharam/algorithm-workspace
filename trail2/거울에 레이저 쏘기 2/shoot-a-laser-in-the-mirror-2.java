import java.io.*;
import java.util.*;

public class Main {
    public static boolean inRange(int x, int y, int n) {
        return ( x >= 0 && x < n && y >= 0 && y < n);
    }

    public static int toDirIn(char dir) {
        if(dir == 'E') return 0;
        else if(dir == 'S') return 1;
        else if(dir == 'W') return 2;
        else return 3;
    }
    public static int toDirDe(char dir) {
        if(dir == 'E') return 0;
        else if(dir == 'S') return 3;
        else if(dir == 'W') return 1;
        else return 2;
    }
    public static char toNumIn(int dir) {
        if(dir == 0) return 'E';
        else if(dir == 1) return 'S';
        else if(dir == 2) return 'W';
        else return 'N';
    }
    public static char toNumDe(int dir) {
        if(dir == 0) return 'E';
        else if(dir == 1) return 'W';
        else if(dir == 2) return 'N';
        else return 'S';
    }


    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dxIn = new int[]{0, 1, 0, -1}; // E, S, W, N
        int[] dyIn = new int[]{1, 0, -1, 0};

        int[] dxDe = new int[]{0, 0, -1, 1}; // E, W, N, S
        int[] dyDe = new int[]{1, -1, 0, 0};

        int n = Integer.parseInt(br.readLine());

        char[][] grid = new char[n][n];

        for(int i = 0; i < n; i++) {
            char[] mirrors = br.readLine().toCharArray();
            for(int j = 0; j < n; j++) {
                grid[i][j] = mirrors[j];
            }
        }

        char prev;
        int dir;

        int k = Integer.parseInt(br.readLine());
        int dim = (k - 1) / n;

        // 처음 진입할 방향 구하기
        if(dim < 1) prev = 'S';
        else if(dim < 2) prev = 'W';
        else if(dim < 3) prev = 'N';
        else prev = 'E';

        // 처음 진입할 위치 구하기
        int[] dx = new int[]{0, 1, 0, -1}; // E, S, W, N
        int[] dy = new int[]{1, 0, -1, 0};

        int x = 0;
        int y = 0;
        int inputDir = 0;

        for(int i = 0; i < k - 1; i++) {
            int nx = x + dx[inputDir];
            int ny = y + dy[inputDir];

            if(inRange(nx, ny, n)) {
                x = nx;
                y = ny;
            }
            else {
                inputDir = (inputDir + 1) % 4;
            }
        }

        int cnt = 0;

        while(inRange(x, y, n)) {
            if(grid[x][y] == '/') {
                dir = toDirIn(prev); // 이전의 문자열을 거울 형태에 따라서 변경
                dir = 3 - dir; // 새로운 방향을 숫자 형태로 구함
                prev = toNumIn(dir); // 숫자 형태의 새로운 방향을 문자형태로 변환 후 전달

                x += dxIn[dir];
                y += dyIn[dir];
            }
            else {
                dir = toDirDe(prev); // 이전의 문자열을 거울 형태에 따라서 변경
                dir = 3 - dir; // 새로운 방향을 숫자 형태로 구함
                prev = toNumDe(dir); // 숫자 형태의 새로운 방향을 문자형태로 변환 후 전달

                x += dxDe[dir];
                y += dyDe[dir];
            }
            cnt++;
        }

        System.out.print(cnt);
    }
}