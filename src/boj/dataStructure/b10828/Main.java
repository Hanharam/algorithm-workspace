package boj.dataStructure.b10828;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] stack = new int[n];
        int top = 0;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            String cmd = st.nextToken();

            switch(cmd){
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    stack[top++] = x;
                    break;
                case "pop":
                    sb.append(top == 0 ? -1 : stack[--top]).append('\n');
                    break;
                case "size":
                    sb.append(top).append('\n');
                    break;
                case "empty":
                    sb.append(top == 0 ? 1 : 0).append('\n');
                    break;
                case "top":
                    sb.append(top == 0 ? -1 : stack[top - 1]).append('\n');
                    break;
            }
        }

        System.out.println(sb);

    }

}
