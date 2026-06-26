import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[] arr = br.readLine().toCharArray();

        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] == '1' || arr[j] == '1') continue;

                char[] sim = arr.clone();
                sim[i] = '1';
                sim[j] = '1';

                int min = Integer.MAX_VALUE;
                int lastIdx = -1;

                for(int k = 0; k < n; k++) {
                    if(sim[k] == '1') {
                        if(lastIdx != -1) {
                            int dis = k - lastIdx;
                            min = Math.min(dis, min);
                        }
                        lastIdx = k;
                    }
                }
                ans = Math.max(ans, min);
            }
        }
        System.out.print(ans);
    }
}