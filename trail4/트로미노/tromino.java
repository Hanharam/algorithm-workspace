import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1 * 3
        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m - 2; j++) {
                int cnt = 0;

                for(int k = 0; k < 3; k++) {
                    cnt += arr[i][j + k];
                }
                ans = Math.max(cnt, ans);
            }
        }

        // 3 * 1
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n - 2; j++) {
                int cnt = 0;

                for(int k = 0; k < 3; k++) {
                    cnt += arr[j + k][i];
                }
                ans = Math.max(cnt, ans);
            }
        }

        // ㄴ
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < m - 1; j++) {
                int cnt = 0;

                for(int l = 0; l < 2; l++) {
                    for(int k = 0; k < 2; k++) {
                        if(l == 0 && k == 1) {}
                        else {cnt += arr[i + l][j + k];}
                    }
                }
                ans = Math.max(cnt, ans);
            }
        }

        // ㄱ
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < m - 1; j++) {
                int cnt = 0;

                for(int l = 0; l < 2; l++) {
                    for(int k = 0; k < 2; k++) {
                        if(l == 1 && k == 0) {}
                        else {cnt += arr[i + l][j + k];}
                    }
                }
                ans = Math.max(cnt, ans);
            }
        }

        // ㄱ
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < m - 1; j++) {
                int cnt = 0;

                for(int l = 0; l < 2; l++) {
                    for(int k = 0; k < 2; k++) {
                        if(l == 0 && k == 0) {}
                        else {cnt += arr[i + l][j + k];}
                    }
                }
                ans = Math.max(cnt, ans);
            }
        }

        // ㄱ
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < m - 1; j++) {
                int cnt = 0;

                for(int l = 0; l < 2; l++) {
                    for(int k = 0; k < 2; k++) {
                        if(l == 1 && k == 1) {}
                        else {cnt += arr[i + l][j + k];}
                    }
                }
                ans = Math.max(cnt, ans);
            }
        }
        System.out.print(ans);
    }
}