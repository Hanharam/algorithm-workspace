package boj.dataStructure.b1874;

import java.io.*;
import java.util.*;


public class Refactoring{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] stack = new int[N];
        int top = 0;
        int next = 1;
        boolean isPossible = true;

        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());

            while (next <= cur) {
                stack[top++] = next;
                next++;
                out.append("+\n");
            }

            if (stack[top - 1] == cur) {
                top--;
                out.append("-\n");
            } else {
                isPossible = false;
                break;
            }
        }

        if(isPossible) System.out.println(out);
        else System.out.println("NO");
    }
}
