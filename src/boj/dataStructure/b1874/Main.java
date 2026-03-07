package boj.dataStructure.b1874;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] stack = new int[n];
        int top = 0;
        int ar = 1;
        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(br.readLine());
            if (ar == cur) {
                stack[top++] = ar;
                ar++;
                sb.append("+\n");
                top--;
                sb.append("-\n");
            } else if (ar < cur) {
                while (ar <= cur) {
                    stack[top++] = ar;
                    ar++;
                    sb.append("+\n");
                }
                top--;
                sb.append("-\n");
            } else {
                if (stack[top - 1] == cur) {
                    top--;
                    sb.append("-\n");
                } else {
                    isPossible = false;
                    break;
                }
            }
        }

        if (isPossible) {
            System.out.println(sb);
        }else System.out.println("NO");
    }
}