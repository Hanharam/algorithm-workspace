import java.io.*;
import java.util.*;

public class Main {
    public static boolean isValid(int n) {
        int[] a = new int[10];
        int num = n;

        while(num > 0) {
            a[num%10]++;
            num = num / 10;
        }

        int numCnt = 0;
        int oneCnt = 0;
        for(int i = 0; i < 10; i++) {
            if(a[i] > 1) numCnt++;
            if(a[i] == 1) oneCnt++;
        }

        if(numCnt == 1 && oneCnt == 1) return true;
        else return false;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int cnt = 0;    
        for(int i = x; i <= y; i++) {
            if(isValid(i)) cnt++;
        }
        System.out.print(cnt);
    }
}

