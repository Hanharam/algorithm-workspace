import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<Character, Integer> mapper = new HashMap<>();
        mapper.put('H', 1); // 주먹
        mapper.put('S', 2); // 가위
        mapper.put('P', 3); // 보자기

        int[] B = new int[n + 1];

        int[] LH = new int[n + 1];
        int[] RH = new int[n + 2];

        int[] LS = new int[n + 1];
        int[] RS = new int[n + 2];

        int[] LP = new int[n + 1];
        int[] RP = new int[n + 2];

        for(int i = 1; i <= n; i++) {
            char command = br.readLine().charAt(0);
            B[i] = mapper.get(command);
        }

        for(int i = 1; i <= n; i++) {
            LH[i] = LH[i - 1];
            LS[i] = LS[i - 1];
            LP[i] = LP[i - 1];
            
            int ops = B[i];
            if(ops == 1) LP[i]++;
            else if(ops == 2) LH[i]++;
            else if(ops == 3) LS[i]++;
        }

        for(int i = n; i >= 1; i--) {
            RH[i] = RH[i + 1];
            RS[i] = RS[i + 1];
            RP[i] = RP[i + 1];

            int ops = B[i];
            if(ops == 1) RP[i]++;
            else if(ops == 2) RH[i]++;
            else if(ops == 3) RS[i]++;
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, LH[i] + Math.max(RS[i + 1], RP[i + 1]));
            ans = Math.max(ans, LS[i] + Math.max(RH[i + 1], RP[i + 1]));
            ans = Math.max(ans, LP[i] + Math.max(RS[i + 1], RH[i + 1]));
        }

        System.out.print(ans);
    }
}