import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] block = new int[200000 + 1];

        int cur = 100000;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);

            if(dir == 'L') {
                while(x-- > 0) {
                    block[cur] = 1;
                    if(x > 0) cur--;
                }
            }
            else {
                while(x-- > 0) {
                    block[cur] = 2;
                    if(x > 0) cur++;
                }
            }
        }
        int w = 0;
        int b = 0;

        for(int i = 0; i < block.length; i++) {
            if(block[i] == 1) w++;
            else if(block[i] == 2) b++;
        }

        System.out.print(w + " " + b);
    }
}