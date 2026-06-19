import java.io.*;
import java.util.*;

public class Main {
    public static int[] dx = {1, 0, -1, 0}; // E, S, W, N
    public static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] command = br.readLine().toCharArray();

        int x = 0;
        int y = 0;
        int dir = 3;
        int time = 1;
        boolean isBack = false;

        for(int i = 0; i < command.length; i++) {
            if(command[i] == 'L') dir = (dir + 4 - 1) % 4;
            else if(command[i] == 'R') dir = (dir + 1) % 4;
            else {
                x += dx[dir];
                y += dy[dir];
            }

            if(x == 0 && y == 0) {
                System.out.print(time);
                isBack = true;
                break;
            }
            time++;
        }

        if(!isBack) System.out.print(-1);
    
    }
}