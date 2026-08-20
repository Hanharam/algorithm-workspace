import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeSet<Integer> s = new TreeSet<>();
        StringTokenizer st;

        int x;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    s.add(x);
                    break;

                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    s.remove(x);
                    break;

                case "find":
                    x = Integer.parseInt(st.nextToken());
                    if(s.contains(x)) System.out.println("true");
                    else System.out.println("false");
                    break;

                case "lower_bound":
                    x = Integer.parseInt(st.nextToken());
                    if(s.ceiling(x) == null) System.out.println("None");
                    else System.out.println(s.ceiling(x));
                    break;

                case "upper_bound":
                    x = Integer.parseInt(st.nextToken());
                    if(s.higher(x) == null) System.out.println("None");
                    else System.out.println(s.higher(x));
                    break;

                case "largest":
                    if(s.size() == 0) System.out.println("None");
                    else System.out.println(s.last());
                    break;

                case "smallest":
                    if(s.size() == 0) System.out.println("None");
                    else System.out.println(s.first());
                    break;
            }

        }
    }
}