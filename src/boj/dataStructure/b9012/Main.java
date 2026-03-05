package boj.dataStructure.b9012;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            char[] stack = new char[50];
            int top = 0;
            boolean ok = true;

            String ps = br.readLine();

            for (int j = 0; j < ps.length(); j++) {
                char a = ps.charAt(j);
                if (a == '(') {
                    stack[top++] = a;
                } else {
                    if (top == 0) {
                        ok = false;
                        break;
                    } else {
                        top--;
                    }
                }
            }
            if (ok && top == 0) {
                out.append("YES\n");
            } else {
                out.append("NO\n");
            }
        }
        System.out.println(out);
    }
}
