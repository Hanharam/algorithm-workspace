package boj.dataStructure.b9093;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            char[] stack = new char[s.length()];
            int top = 0;

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (c != ' ') {
                    stack[top++] = c;
                } else {
                    while (top > 0) {
                        sb.append(stack[--top]);
                    }
                    sb.append(c);
                }
            }

            while (top > 0) {
                sb.append(stack[--top]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
