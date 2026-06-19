import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[][] grid = new int[n][n];
        
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};

        int x = n / 2;
        int y = n / 2;
        
        int dir = 0;
        int moveCount = 1;
        int num = 1;
        
        grid[x][y] = num++;

        while (num <= n * n) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < moveCount; j++) {
                    if (num > n * n) break;
                    
                    x += dx[dir];
                    y += dy[dir];
                    grid[x][y] = num++;
                }
                
                if (num > n * n) break;
                
                dir = (dir + 1) % 4; 
            }
            moveCount++; 
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}