import java.io.*;
import java.util.*;

public class Main {
    public static int[][] arr;

    public static void counterclockwise(int x, int y, int m1, int m2, int m3, int m4) {
        int temp = arr[x][y];

        for(int i = 0; i < m4; i++) {
            arr[x][y] = arr[x - 1][y - 1];
            x--;
            y--;
        }

        for(int i = 0; i < m3; i++) {
            arr[x][y] = arr[x - 1][y + 1];
            x--;
            y++;
        }

        for(int i = 0; i < m2; i++) {
            arr[x][y] = arr[x + 1][y + 1];
            x++;
            y++;
        }

        for(int i = 0; i < m1; i++) {
            arr[x][y] = arr[x + 1][y - 1];
            x++;
            y--;
        }

        arr[x - 1][y + 1] = temp;
    }

    public static void clockwise(int x, int y, int m1, int m2, int m3, int m4) {
        int temp = arr[x][y];

        for(int i = 0; i < m1; i++) {
            arr[x][y] = arr[x - 1][y + 1];
            x--;
            y++;
        }

        for(int i = 0; i < m2; i++) {
            arr[x][y] = arr[x - 1][y - 1];
            x--;
            y--;
        }

        for(int i = 0; i < m3; i++) {
            arr[x][y] = arr[x + 1][y - 1];
            x++;
            y--;
        }

        for(int i = 0; i < m4; i++) {
            arr[x][y] = arr[x + 1][y + 1];
            x++;
            y++;
        }

        arr[x - 1][y - 1] = temp;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;
        int m1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int m3 = Integer.parseInt(st.nextToken());
        int m4 = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        if(dir == 0) counterclockwise(x, y, m1, m2, m3, m4);
        else clockwise(x, y, m1, m2, m3, m4);

        for(int i = 0; i < n; i++) {
            for(int num : arr[i]) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}