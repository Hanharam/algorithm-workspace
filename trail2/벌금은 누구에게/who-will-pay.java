import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] std = new int[N + 1];
        boolean isTrue = false;

        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());
            std[num]++;
            if(std[num] >= K) {
                System.out.print(num);
                isTrue = true;
                break;
            }
        }

        if(!isTrue) System.out.print(-1);
    }
}