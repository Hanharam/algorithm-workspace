import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static ArrayList<Integer> ans = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();
    public static boolean[] visited = new boolean[9];

    public static void printArray() {
        for(int i = 0; i < n; i++) {
            sb.append(ans.get(i)).append(" ");
        }
        sb.append("\n");
    }

    public static void choose(int curNum) {
        if(curNum == n + 1) {
            printArray();
            return;
        }

        for(int i = n; i >= 1; i--) {
            if(visited[i]) continue;

            ans.add(i);
            visited[i] = true;
            choose(curNum + 1);
            ans.remove(ans.size() - 1);
            visited[i] = false;
        }
        return;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        choose(1);
        System.out.print(sb);
    }
}