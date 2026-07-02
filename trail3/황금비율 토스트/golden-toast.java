import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String line = br.readLine();
        LinkedList<Character> l = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            l.addLast(line.charAt(i));
        }
        
        ListIterator<Character> lt = l.listIterator(l.size());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);

            if(c == 'L' && lt.hasPrevious()) lt.previous();
            else if(c == 'R' && lt.hasNext()) lt.next();
            else if(c == 'D' && lt.hasNext()) {
                lt.next();
                lt.remove();
            }
            else if(c == 'P'){
                char ch = st.nextToken().charAt(0);
                lt.add(ch);
            }
        }

        for(char c : l) {
            System.out.print(c);
        }
    }
}