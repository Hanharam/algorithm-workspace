import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] first = new int[n + 1];
        int[] second = new int[n + 1];
        int[] third = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            first[i] = first[i - 1];
            second[i] = second[i - 1];
            third[i] = third[i - 1];

            int num = Integer.parseInt(br.readLine());

            if(num == 1) {
                first[i]++;
            } else if(num == 2) {
                second[i]++;
            } else if(num == 3) {
                third[i]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(first[b] - first[a - 1]).append(" ")
            .append(second[b] - second[a - 1]).append(" ")
            .append(third[b] - third[a - 1]).append("\n");
        }
        System.out.print(sb);
    }
}