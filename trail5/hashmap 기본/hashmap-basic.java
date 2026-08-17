import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> m = new HashMap<>();

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int k = Integer.parseInt(st.nextToken());

            if(command.equals("add")) {
                int v = Integer.parseInt(st.nextToken());
                m.put(k, v);
            }
            else if(command.equals("remove")) {
                m.remove(k);
            }
            else if(command.equals("find")) {
                if(m.containsKey(k)) System.out.println(m.get(k));
                else System.out.println("None");
            }
        }
    }
}