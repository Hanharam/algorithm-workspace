import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] b = new int[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    int[] line = new int[101];
                    boolean isTrue = true;
                    // 점 세개 정함

                    // 나머지 점들 반복
                    for(int l = 0; l < n; l++) {
                        if(l == i || l == j || l == k) continue;

                        for(int p = a[l]; p <= b[l]; p++) {
                            line[p]++;
                        }
                    }

                    for(int l = 0; l < 101; l++) {
                        if(line[l] > 1) isTrue = false;
                    }

                    if(isTrue) cnt++;
                }
            }
        }
        System.out.print(cnt);
    }
}