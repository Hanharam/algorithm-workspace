import java.io.*;
import java.util.*;

public class Main {
    public static int k, n;

    public static ArrayList<Integer> answer = new ArrayList<>();

    public static void printArray() {
        for(int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
        System.out.println();
    }

    public static void choose(int cnt) {

        if(cnt == n + 1) {
            printArray();
            return;
        }

        for(int i = 1; i <= k; i++) {

            if(cnt >= 3 && answer.get(cnt - 2) == i && answer.get(cnt - 3) == i) {
                continue;
            } 
            
            answer.add(i);
            choose(cnt + 1);
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