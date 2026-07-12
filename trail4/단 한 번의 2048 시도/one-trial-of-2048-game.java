import java.io.*;
import java.util.*;

public class Main {
    public static int[][] grid = new int[4][4];
    public static int n = 4;

    public static void moveR() {
        for(int i = 0; i < n; i++) {
            int[] temp = new int[n];
            int idx = n - 1;

            for(int j = n - 1; j >= 0; j--) {
                if(grid[i][j] != 0) {

                    if(temp[idx] == 0) {
                        temp[idx] = grid[i][j];
                    }
                    else if(temp[idx] == grid[i][j]) {
                        temp[idx] *= 2;
                        idx--;
                    }
                    else{
                        idx--;
                        temp[idx] = grid[i][j];
                    }
                }
            }

            for(int j = n - 1; j >= 0; j--) {
                grid[i][j] = temp[j];
            }
        }
    }

    public static void moveD() {
        for(int j = 0; j < n; j++) {
            int[] temp = new int[n];
            int idx = n - 1;

            for(int i = n - 1; i >= 0; i--) {
                if(grid[i][j] != 0) {

                    if(temp[idx] == 0) {
                        temp[idx] = grid[i][j];
                    }
                    else if(temp[idx] == grid[i][j]) {
                        temp[idx] *= 2;
                        idx--;
                    }
                    else{
                        idx--;
                        temp[idx] = grid[i][j];
                    }
                }
            }

            for(int i = n - 1; i >= 0; i--) {
                grid[i][j] = temp[i];
            }
        }
    }

    public static void moveL() {
        for(int i = 0; i < n; i++) {
            int[] temp = new int[n];
            int idx = 0;

            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 0) {

                    if(temp[idx] == 0) {
                        temp[idx] = grid[i][j];
                    }
                    else if(temp[idx] == grid[i][j]) {
                        temp[idx] *= 2;
                        idx++;
                    }
                    else{
                        idx++;
                        temp[idx] = grid[i][j];
                    }
                }
            }

            for(int j = n - 1; j >= 0; j--) {
                grid[i][j] = temp[j];
            }
        }
    }

    public static void moveU() {
        for(int j = 0; j < n; j++) {
            int[] temp = new int[n];
            int idx = 0;

            for(int i = 0; i < n; i++) {
                if(grid[i][j] != 0) {

                    if(temp[idx] == 0) {
                        temp[idx] = grid[i][j];
                    }
                    else if(temp[idx] == grid[i][j]) {
                        temp[idx] *= 2;
                        idx++;
                    }
                    else{
                        idx++;
                        temp[idx] = grid[i][j];
                    }
                }
            }

            for(int i = n - 1; i >= 0; i--) {
                grid[i][j] = temp[i];
            }
        }
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        char dir = br.readLine().charAt(0);

        if(dir == 'R') moveR();
        else if(dir == 'L') moveL();
        else if(dir == 'U') moveU();
        else if(dir == 'D') moveD();


        for(int i = 0; i < 4; i++) {
            for(int num : grid[i]) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }
}