import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int cnt = 0;
    public static int[] memo = new int[1001];

    public static int step(int x) {
        if(memo[x] != -1) {
            return memo[x];
        }

        if(x < 2) {
            return 0;
        }
        else if(x <= 3) {
            return 1;
        }

        memo[x] = (step(x - 2) + step(x - 3)) % 10007;

        return memo[x];
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Arrays.fill(memo, -1);

        System.out.print(step(n));
    }
}