import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                for(int k = 1; k < n + 1; k++) {
                    if(Math.abs(a - i) <= 2 || Math.abs(b - j) <= 2 || Math.abs(c - k) <= 2) cnt++;
                }
            }
        }
        System.out.print(cnt);
    }
}