import java.io.*;
import java.util.*;

class Student {
    int s, b;

    public Student(int s, int b) {
        this.s = s;
        this.b = b;
    }
}

public class Main {
    public static int n;
    public static int[][][] dp;
    public static Student[] students;

    public static void init() {
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= 11; j++) {
                for(int k = 0; k <= 9; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        dp[0][0][0] = 0;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        students = new Student[n];
        dp = new int[n + 1][12][10];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            students[i] = new Student(s, b);
        }

        init();

        // 포함 vs 미포함, 축구 vs 야구
        // n의 진행은 학생 수 대로 진행
        for(int i = 0; i < n; i++) {
            int s = students[i].s;
            int b = students[i].b;

            for(int j = 0; j <= 11; j++) {
                for(int k = 0; k <= 9; k++) {

                    if(dp[i][j][k] < 0) continue;

                    // 미포함 (원래 값 vs 업데이트 값)
                    dp[i + 1][j][k] = Math.max(dp[i+1][j][k], dp[i][j][k]);

                    // 포함
                    // 축구 인재
                    if(j < 11) dp[i + 1][j + 1][k] = Math.max(dp[i + 1][j + 1][k], dp[i][j][k] + s);

                    // 야구 인재
                    if(k < 9) dp[i + 1][j][k + 1] = Math.max(dp[i + 1][j][k + 1], dp[i][j][k] + b);
                }
            }
        }
        System.out.print(dp[n][11][9]);
    }
}