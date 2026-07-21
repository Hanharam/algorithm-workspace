import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int cnt = 0;

    public static ArrayList<Integer> answer = new ArrayList<>();

    public static void choose(int curNum) {
        if(curNum == n) {
            cnt++;
            return;
        }

        for(int i = 1; i <= 4; i++) {
            if(curNum + i <= n) {
                choose(curNum + i);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        choose(0);

        System.out.print(cnt);
    }
}