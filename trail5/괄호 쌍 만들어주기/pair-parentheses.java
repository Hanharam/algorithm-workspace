import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] command = br.readLine().toCharArray();

        int n = command.length;
        int[] R = new int[n];
        
        for(int i = n - 1; i >= 1; i--) {
            R[i - 1] = R[i];

            if(command[i] == ')' && command[i - 1] == ')') {
                R[i - 1]++;
            }
        }

        long ans = 0l;
        for(int i = 0; i < n - 1; i++) {
            if(command[i] == '(' && command[i + 1] == '(') {
                ans += R[i];
            }
        }

        System.out.print(ans);
    }
}