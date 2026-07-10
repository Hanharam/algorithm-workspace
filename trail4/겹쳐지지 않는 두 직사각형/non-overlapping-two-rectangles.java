import java.io.*;
import java.util.*;

public class Main {
    public static int[][] arr;

    public static int getWidth(int x1, int y1, int x2, int y2) {
        int width = 0;

        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                width += arr[i][j];
            }
        }

        return width;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 점 하나 정해서 거기서 나올 수 있는 모든 직사각형 구하기 a
        // 다른 점도 거기서 나올 수 있는 모든 직사각형 구하기 b

        // a를 골랐을 떄 가능한 b의 개수는 (n * m - 1) 개

        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) { // 첫번재 직사각형 시작점
                int x1 = i;
                int y1 = j;

                int width1;
                int width2;

                for(int q = i; q < n; q++) {
                    for(int w = j; w < m; w++) { // 첫번째 직사각형 끝점
                        int a1 = q;
                        int b1 = w;

                        for(int k = 0; k < n; k++) {
                            for(int l = 0; l < m; l++) { // 두번째 직사각형 시작점
                                int x2 = k;
                                int y2 = l;

                                if(x1 == x2 && y1 == y2) continue;

                                for(int g = k; g < n; g++) {
                                    for(int h = l; h < m; h++) {
                                        int a2 = g;
                                        int b2 = h; // 두번째 직사각형 끝점
                                    

                                        if(a1 < x2 || x1 > a2 || b1 < y2 || y1 > b2) {
                                            width1 = getWidth(x1, y1, a1, b1);
                                            width2 = getWidth(x2, y2, a2, b2);

                                            ans = Math.max(ans, width1 + width2);
                                        }
                                    }
                                }

                            }
                        }

                        
                    }
                }

            }
        }

        System.out.print(ans);
    }
}