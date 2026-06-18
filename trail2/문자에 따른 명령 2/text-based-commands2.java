import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, -1, 0, 1};

        char[] command = br.readLine().toCharArray();


        int x = 0;
        int y = 0;
        int direction = 3;

        for(int i = 0; i < command.length; i++) {
            if(command[i] == 'L') direction = (direction - 1 + 4) % 4;
            else if(command[i] == 'R') direction = (direction + 1) % 4;
            else {
                x += dx[direction];
                y += dy[direction];
            }
        }

        System.out.print(x + " " + y);
    }
}