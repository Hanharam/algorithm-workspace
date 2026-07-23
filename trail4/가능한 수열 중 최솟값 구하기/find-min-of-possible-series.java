import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static boolean isFinished = false;

    public static ArrayList<Integer> answer = new ArrayList<>();

    public static void printArray() {
        for(int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i));
        }
    }
    

    public static boolean canPlace(int cnt, int num) {
        boolean isTrue = false;

        for(int i = 1; i <= cnt/2; i++) { // 1, 2, 3
            isTrue = false;
            for(int j = 1; j <= i; j++) { // 1, 2, 3
                if(answer.get(answer.size() - j) != answer.get(answer.size() - j - i)) {
                    isTrue = true;
                }
            }
            if(!isTrue) return false;
        }
        return true;
    }

    public static void choose(int cnt) {
        if(isFinished) return;
        
        if(cnt == n + 1) {
            printArray();
            isFinished = true;
            return;
        }

        for(int i = 4; i <= 6; i++) {

            answer.add(i);
            if(canPlace(cnt, i)) {
                choose(cnt + 1);
            }
            answer.remove(answer.size() - 1);
        }
        return;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        choose(1);
    }
}