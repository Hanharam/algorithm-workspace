import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static ArrayList<Integer> answer = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void printArray() {
        for(int i = 0; i < m; i++) {
            sb.append(answer.get(i)).append(" ");
        }
        sb.append("\n");
    }

    public static void choose(int curNum, int cnt) {
        if(curNum == m + 1) {
            printArray();
        }

        for(int i = cnt; i <= n; i++) {
            answer.add(i);
            choose(curNum + 1, i + 1);
            answer.remove(answer.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        choose(1, 1);

        System.out.print(sb);
    }
}