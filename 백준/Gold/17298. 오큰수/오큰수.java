
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] bx = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bx[i] = Integer.parseInt(st.nextToken());
        }

        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();


        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= bx[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(bx[i]);
        }

        for (int i = 0; i < n ; i++) {
            out.append(ans[i]).append(" ");
        }

        System.out.println(out);
    }
}
