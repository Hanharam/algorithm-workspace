import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[][] grid;
    public static int[][] temp;

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static int explode(int x, int y) {
        int area = grid[x][y];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                temp[i][j] = grid[i][j];
            }
        }

        

        for(int i = 0; i < area; i++) {
            if(inRange(x + i, y)) temp[x + i][y] = 0;
            if(inRange(x, y + i)) temp[x][y + i] = 0;
            if(inRange(x - i, y)) temp[x - i][y] = 0;
            if(inRange(x, y - i)) temp[x][y - i] = 0;
        }

        for(int i = 0; i < n; i++) {
            fall(i);
        }
        
        int totalCnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(temp[i][j] == 0) continue;
                totalCnt += getNumOfPair(i, j);
            }
        }

        return totalCnt;
    }

    public static void fall(int col) {
        int[] tempArray = new int[n];
        int idx = n - 1;

        for(int i = n - 1; i >= 0; i--) {
            if(temp[i][col] != 0) tempArray[idx--] = temp[i][col];
        }

        for(int i = 0; i < n; i++) {
            temp[i][col] = tempArray[i];
        }
    }

    public static int getNumOfPair(int x, int y) {
        int num = temp[x][y];
        int cnt = 0;

        if(inRange(x + 1, y) && num == temp[x + 1][y]) cnt++;
        if(inRange(x, y + 1) && num == temp[x][y + 1]) cnt++;

        return cnt;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                temp = new int[n][n];
                
                int cnt = explode(i, j);

                ans = Math.max(ans, cnt);
            }
        }

        // for(int q = 0; q < n; q++) {
        //     for(int w = 0; w < n; w++) {
        //         System.out.print(temp[q][w] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        System.out.print(ans);
    }
}