import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] grid = new int[3][3];

        for(int i = 0; i < 3; i++) {
            String st = br.readLine();
            for(int j = 0; j < 3; j++) {
                grid[i][j] = st.charAt(j) - '0';
            }
        }

        int[][] flat = new int[8][3];

        int[] dx = new int[]{0, 1, 1, 1}; // 오, 아래, 오른쪽 아래 대각선, 왼쪽 아래 대각선
        int[] dy = new int[]{1, 0, 1, -1};

        for(int i = 0; i < 8; i++) {
            int nx;
            int ny;
            int dir;

            if(i == 0) {
                nx = 0;
                ny = 0;
                dir = 0;
            }
            else if(i == 1) {
                nx = 1;
                ny = 0;
                dir = 0;
            }
            else if(i == 2) {
                nx = 2;
                ny = 0;
                dir = 0;
            }
            else if(i == 3) {
                nx = 0;
                ny = 0;
                dir = 1;
            }
            else if(i == 4) {
                nx = 0;
                ny = 1;
                dir = 1;
            }
            else if(i == 5) {
                nx = 0;
                ny = 2;
                dir = 1;
            }
            else if(i == 6) {
                nx = 0;
                ny = 0;
                dir = 2;
            }
            else {
                nx = 0;
                ny = 2;
                dir = 3;
            }


            for(int j = 0; j < 3; j++) {
                flat[i][j] = grid[nx][ny];
                nx += dx[dir];
                ny += dy[dir];
            }
        }

        int sum = 0;
        
        for (int team1 = 0; team1 < 9; team1++) {
            for (int team2 = team1 + 1; team2 < 10; team2++) {
                
                boolean isWin = false;
                
                for (int i = 0; i < 8; i++) {
                    int count1 = 0;
                    int count2 = 0;
                    
                    for (int j = 0; j < 3; j++) {
                        if (flat[i][j] == team1) count1++;
                        if (flat[i][j] == team2) count2++;
                    }
                    
                    if (count1 + count2 == 3 && count1 > 0 && count2 > 0) {
                        isWin = true;
                        break; 
                    }
                }
                if (isWin) {
                    sum++;
                }
            }
        }
        System.out.print(sum);
    }
}
        
