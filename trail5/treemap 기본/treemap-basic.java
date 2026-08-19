import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeMap<Integer, Integer> m = new TreeMap<>();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("add")) {
                int k = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                m.put(k, v);
            }
            else if(command.equals("remove")) {
                int k = Integer.parseInt(st.nextToken());
                if(m.containsKey(k)) m.remove(k);
            }
            else if(command.equals("find")) {
                int k = Integer.parseInt(st.nextToken());
                if(m.containsKey(k)) System.out.println(m.get(k));
                else System.out.println("None");
            }
            else if(command.equals("print_list")) {
                if(m.isEmpty()) System.out.print("None");
                else {
                    Iterator<Map.Entry<Integer, Integer>> it = m.entrySet().iterator();

                    while(it.hasNext()) {
                        Map.Entry<Integer, Integer> entry = it.next();
                        System.out.print(entry.getValue() + " ");
                    }
                }
                System.out.println();
            }
            else {
                System.out.print("Wrong Command");
                break;
            }
        }
    }
}