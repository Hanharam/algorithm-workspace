import java.io.*;
import java.util.*;

public class Main {
    public static int n, k;

    public static ArrayList<Integer> answer = new ArrayList<>();

    public static void printArray() {
        for(int num : answer) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void choose(int curNum) {

        if(curNum == n + 1) {
            printArray();
            return;
        }

        for(int i = 1; i <= k; i++) {
            answer.add(i);
            choose(curNum + 1);
            answer.remove(answer.size() - 1);
        }

        return;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        choose(1);

    }
}