import java.io.*;
import java.util.*;

public class  Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashSet<Integer> s = new HashSet<>();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int k = Integer.parseInt(st.nextToken());

            if(command.equals("add")) {
                if(!s.contains(k)) s.add(k);
            }
            else if(command.equals("remove")) {
                s.remove(k);
            }
            else if(command.equals("find")) {
                if(s.contains(k)) System.out.println(true);
                else System.out.println(false);
            }

        }
    }
}