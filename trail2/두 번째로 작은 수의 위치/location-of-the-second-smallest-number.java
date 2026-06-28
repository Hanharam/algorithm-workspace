import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        int secCnt = 0;
        int firstCnt = 0;

        int posFirst = 0;
        int posSecond = 0;

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(first > num) {
                second = first;
                first = num;

                posSecond = posFirst;
                posFirst = i + 1;

                secCnt = firstCnt;
                firstCnt = 1;
            }
            else if(first == num) {
                firstCnt++;
            }
            else if(second > num) {
                second = num;
                posSecond = i + 1;
                secCnt = 1;
            }
            else if(second == num) {
                secCnt++;
            }
        }

        if(secCnt != 1) System.out.print(-1);
        else System.out.print(posSecond);
    }
}