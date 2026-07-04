import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        int[] arr;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        int top = 0;

        for(int i = 0; i < n; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            String st = s.nextToken();

            if(st.equals("push")) {
                arr[top++] = Integer.parseInt(s.nextToken());
            }
            else if(st.equals("pop")) {
                System.out.println(arr[--top]);
            }
            else if(st.equals("size")) {
                System.out.println(top);
            }
            else if(st.equals("empty")) {
                if(top == 0) System.out.println(1);
                else System.out.println(0);
            }
            else if(st.equals("top")) {
                System.out.println(arr[top - 1]);
            }
        }
    }
}