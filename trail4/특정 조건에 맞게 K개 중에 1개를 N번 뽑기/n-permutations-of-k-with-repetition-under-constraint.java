import java.io.*;
import java.util.*;

public class Main {
    public static int k, n;
    public static ArrayList<Integer> answer = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void choose(int cnt) {
        if(cnt == n + 1) {
            for(int i = 0; i < answer.size(); i++) {
                sb.append(answer.get(i)).append(" ");
            }
            sb.append("\n");
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
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        choose(1);
        
        System.out.print(sb);
    }
}