import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] arr = new ArrayList[g];
        HashSet<Integer> s = new HashSet<>();

        s.add(1);

        for(int i = 0; i < g; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < g; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            for(int j = 0; j < num; j++) {
                int person = Integer.parseInt(st.nextToken());
                arr[i].add(person);
            }
        }


        boolean changed = true;
        while(changed) {
            changed = false;

            for(int i = 0; i < g; i++) {
                int size = arr[i].size();

                for(int j = size - 1; j >= 0; j--) {
                    if(s.contains(arr[i].get(j))) arr[i].remove(j);
                }

                if(arr[i].size() == 1) {
                    if (s.add(arr[i].get(0))) {
                        changed = true;
                    }
                }
            }
        }
        System.out.print(s.size());
    }
}