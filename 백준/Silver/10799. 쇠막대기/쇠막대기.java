import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        char[] stack = new char[s.length()];
        int top = 0;
        int idx = 0;
        int total = 0;

        char[] sen = s.toCharArray();

        while (idx < s.length()) {
            if (sen[idx] == '(' && sen[idx + 1] == ')') {
                idx++;
                total += top;
            } else if (sen[idx] == '(') {
                stack[top++] = sen[idx];
            } else {
                top--;
                total++;
            }
            idx++;
        }

        System.out.println(total);
    }
}