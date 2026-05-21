import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(num);

        for(int i = 0; i < n; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();

        Integer[] num2 = Arrays.stream(num).boxed().toArray(Integer[]::new);

        Arrays.sort(num2, Collections.reverseOrder());

        for(int i = 0; i < n; i++) {
            System.out.print(num2[i] + " ");
        }

    }
}