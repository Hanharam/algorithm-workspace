import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[][] grid = new char[10][10];

        int xL = 0, yL = 0;
        int xR = 0, yR = 0;
        int xB = 0, yB  =0;

        for(int i = 0; i < 10; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                char ch = grid[i][j];
                if(ch == 'L') {
                    xL = i;
                    yL = j;
                }
                else if(ch == 'R') {
                    xR = i;
                    yR = j;
                }
                else if(ch == 'B') {
                    xB = i;
                    yB = j;
                }

                grid[i][j] = ch;
            }
        }
        int dist = Math.abs(xB - xL) + Math.abs(yB - yL) - 1;

        if (xB == xL && xL == xR && ((yL < yR && yR < yB) || (yB < yR && yR < yL))) {
            dist += 2;
        }
        else if (yB == yL && yL == yR && ((xL < xR && xR < xB) || (xB < xR && xR < xL))) {
            dist += 2;
        }
        System.out.print(dist);
    }
}