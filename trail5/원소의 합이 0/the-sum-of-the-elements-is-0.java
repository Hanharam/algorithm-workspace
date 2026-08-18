import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] a;
    public static int[] b;
    public static int[] c;
    public static int[] d;

    public static HashMap<Integer, Integer> m = new HashMap<>();
    public static HashMap<Integer, Integer> m2 = new HashMap<>();

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        a = new int[n];
        b = new int[n];
        c = new int[n];
        d = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int sum = a[i] + b[j];
                m.put(sum, m.getOrDefault(sum, 0) + 1);
            }  
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int need = -(c[i] + d[j]);
                ans += m.getOrDefault(need, 0);
            }
        }

        System.out.print(ans);

        
    }
}