import java.io.*;
import java.util.*;

public class Main {
    public static int n;

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;

        int area = arr[r][c];

        for(int i = 0; i < area; i++) {
            if(inRange(r + i, c)) arr[r+i][c] = 0;
            if(inRange(r, c + i)) arr[r][c + i] = 0;
            if(inRange(r - i, c)) arr[r - i][c] = 0;
            if(inRange(r, c - i)) arr[r][c - i] = 0;
        }
        
        for(int i = 0; i < n; i++) {
            int idx = n - 1;
            int[] temp = new int[n];

            for(int j = n - 1; j >= 0; j--) { // 아래부터 위로 탐색
                if(arr[j][i] != 0) {
                    temp[idx--] = arr[j][i]; // 배열 0 이 맨 아래 블럭
                }
            }

            for(int j = n - 1; j >= 0; j--) {
                arr[j][i] = temp[j];
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