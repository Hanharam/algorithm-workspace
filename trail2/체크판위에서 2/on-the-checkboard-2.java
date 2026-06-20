import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] a = new char[r][c];

        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < c; j++) {
                a[i][j] = st.nextToken().charAt(0);
            }
        }

        char startColor = a[0][0];
        char endColor = a[r-1][c-1];

        int cnt = 0;
        for(int i = 1; i < r - 1; i++) {
            for(int j = 1; j < c - 1; j++) {
                if(a[i][j] == startColor) continue;

                else{
                    for(int k = i + 1; k < r - 1; k++) {
                        for(int l = j + 1; l < c - 1; l++) {
                            if(a[k][l] == a[i][j]) continue;

                            if(a[k][l] != endColor) {
                                cnt++;
                            }
                        }
                    }   
                }
            }
        }
        System.out.print(cnt);
    }
}