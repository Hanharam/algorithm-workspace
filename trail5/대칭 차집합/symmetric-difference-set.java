import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashSet<Integer> SetA = new HashSet<>();
        HashSet<Integer> SetB = new HashSet<>();
        HashSet<Integer> answer = new HashSet<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            SetA.add(a[i]);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            SetB.add(b[i]);
        }

        for(int i = 0; i < n; i++) {
            if(!SetB.contains(a[i])) {
                answer.add(a[i]);
            }
        }

        for(int i = 0; i < m; i++) {
            if(!SetA.contains(b[i])) {
                answer.add(b[i]);
            }
        }

        System.out.println(answer.size());
    }
}