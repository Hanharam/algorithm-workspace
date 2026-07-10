import java.io.*;
import java.util.*;

public class Main {
    public static int[][] arr;

    public static int n, m;

    public static boolean upPositive(int row) {
        if(row - 1 < 0) return false;

        for(int i = 0; i < m; i++) {
            if(arr[row][i] == arr[row - 1][i]) return true;
        }
        return false;
    }

    public static boolean downPositive(int row) {
        if(row + 1 > n - 1) return false;

        for(int i = 0; i < m; i++) {
            if(arr[row][i] == arr[row + 1][i]) return true;
        }
        return false;
    }

    public static void move(int row, char dir) {
        if(dir == 'R') {
            int temp = arr[row][0];
            for(int i = 0; i < m - 1; i++) {
                arr[row][i] = arr[row][i + 1];
            }
            arr[row][m - 1] = temp;
        }
        else {
            int temp = arr[row][m - 1];
            for(int i = m - 1; i > 0; i--) {
                arr[row][i] = arr[row][i - 1];
            }
            arr[row][0] = temp;
        }
    }


    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            char dir = st.nextToken().charAt(0);

            int up = row;
            int down = row;

            char dirUp = dir;
            char dirDown = dir;

            // 일단 중앙값 밀기 진행
            move(row, dir);

            while(upPositive(up)) {
                up--;
                if(dirUp == 'L') dirUp = 'R';
                else if(dirUp == 'R') dirUp = 'L';

                move(up, dirUp);
            }

            while(downPositive(down)) {
                down++;
                if(dirDown == 'L') dirDown = 'R';
                else if(dirDown == 'R') dirDown = 'L';

                move(down, dirDown);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int num : arr[i]) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}