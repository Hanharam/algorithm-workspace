import java.io.*;
import java.util.*;

public class Main {
    public static int[] block = new int[200000]; //white : 1 , black : 2, gray : 3
    public static int[] white = new int[200000];
    public static int[] black = new int[200000];

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cur = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);

            if(direction == 'L') {
                paint(cur - x + 1, cur, direction);
                cur = cur - x + 1;
            }
            else{
                paint(cur, cur + x - 1, direction);
                cur = cur + x - 1;
            }
        }

        int w = 0, b = 0, g = 0;
        for(int i = 0; i < 200000; i++){
            if(block[i] == 1) w++;
            else if(block[i] == 2) b++;
            else if(block[i] == 3) g++;
        }

        System.out.print(w + " " + b + " " + g);
    }

    public static void paint(int a, int b, char dir) {
        if(dir == 'L'){
            for(int i = a + 100000; i <= b + 100000; i++) {
                white[i]++;
                if(white[i] >= 2 && black[i] >= 2) block[i] = 3;
                else block[i] = 1;
            }
        } else {
            for(int i = a + 100000; i <= b + 100000; i++) {
                black[i]++;
                if(white[i] >= 2 && black[i] >= 2) block[i] = 3;
                else block[i] = 2;
            }
        }
    }
}