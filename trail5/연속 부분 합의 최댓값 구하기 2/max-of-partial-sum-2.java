import java.util.*;
import java.io.*;

public class Main {
    public static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            sum += num;
            answer = Math.max(answer, sum);

            if(sum < 0) sum = 0;
        }
        System.out.print(answer);
    }
}