import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] infection = new int[N + 1];
        int[] valid = new int[N + 1];
        int[] arrX = new int[251];
        int[] arrY = new int[251];

        infection[P] = 1;
        valid[P] = K;
        
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arrX[t] = x;
            arrY[t] = y;   
        }

        for(int i = 0; i < 251; i++) {
            int x = arrX[i];
            int y = arrY[i];

            if(x == 0 || y == 0) continue;
            
            boolean xInfected = (infection[x] == 1);
            boolean yInfected = (infection[y] == 1);

            if(xInfected && valid[x] > 0) {
                if(infection[y] != 1) {
                    infection[y] = 1;
                    valid[y] = K;
                }
                valid[x]--;
            }
            if(yInfected && valid[y] > 0) {
                if(infection[x] != 1) {
                    infection[x] = 1;
                    valid[x] = K;
                }
                valid[y]--;
            }
        }

        for(int i = 1; i <= N; i++){
            System.out.print(infection[i]);
        }

    }
}