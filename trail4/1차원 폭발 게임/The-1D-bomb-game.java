import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_NUM = 100;

    public static int n, m, endOfArray;
    public static int[] numbers = new int[MAX_NUM];

    public static int getEndIdxofExplosion(int curIdx, int num) {
        int endIdx = curIdx + 1;
        while(endIdx < endOfArray) {
            if(numbers[endIdx] == num) {
                endIdx++;
            }
            else{
                break;
            }
        }
        return endIdx - 1;
    }

    public static void cutArray(int curIdx, int endIdx) {
        int cutlen = endIdx - curIdx + 1;
        for(int i = endIdx + 1; i < endOfArray; i++) {
            numbers[i - cutlen] = numbers[i];
        }

        endOfArray -= cutlen;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        endOfArray = n;

        boolean didExplode;
        int curIdx;
        do {
            didExplode = false;
            curIdx = 0;

            while(curIdx < endOfArray) {
                int endIdx = getEndIdxofExplosion(curIdx, numbers[curIdx]);

                if(endIdx - curIdx + 1 >= m) {
                    cutArray(curIdx, endIdx);
                    didExplode = true;
                }
                else {
                    curIdx = endIdx + 1;
                }
            }

        } while(didExplode);

        System.out.println(endOfArray);
        for(int i = 0; i < endOfArray; i++) {
            System.out.println(numbers[i]);
        }
    }
}