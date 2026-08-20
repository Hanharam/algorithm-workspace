import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++) {
            TreeSet<Integer> s = new TreeSet<>();
            int k = Integer.parseInt(br.readLine());

            for(int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char command = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if(command == 'D' && s.size() > 0) {
                    if(num == 1) s.remove(s.last());
                    else if(num == -1) s.remove(s.first());
                }
                else if(command == 'I') {
                    s.add(num);
                }
            }

            if(s.size() == 0) System.out.println("EMPTY");
            else System.out.println(s.last() + " " + s.first());
        }
        
    }
}