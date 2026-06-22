import java.io.*;
import java.util.*;

public class Main {
    public static Info[] info;

    public static boolean isValid(int x, int y, int z, int n) {
        int[] correct = new int[]{x, y, z};
        for(int i = 0; i < n; i++) {
            int st = 0;
            int ball = 0;

            int[] number = new int[3];
            int past = info[i].num;

            for(int j = 2; j >= 0; j--) {
                number[j] = past % 10;
                past = past/10;
            }

            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    if(correct[j] == number[k]) {
                        if(j == k) st++;
                        else ball++;
                    }
                }
            }
             if(info[i].one != st || info[i].two != ball) {
                return false; 
            }
        }
        return true;
    }

    public static class Info {
        int num;
        int one;
        int two;

        public Info(int n, int o, int t) {
            this.num = n;
            this.one = o;
            this.two = t;
        }
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        info = new Info[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());

            info[i] = new Info(num, one, two);
        }

        int answer = 0;

        for(int i = 1; i <= 9; i++) {
            for(int j = 1; j <= 9; j++) {
                for(int k = 1; k <= 9; k++) {
                    if(i ==j || j ==k || i ==k) continue;
                    if(isValid(i, j, k, n)) answer++;
                }
            }
        }
        System.out.print(answer);
    }
}