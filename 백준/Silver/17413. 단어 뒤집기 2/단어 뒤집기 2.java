
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        String sen = br.readLine();

        char[] sen2 = sen.toCharArray();

        Deque<Character> stack = new ArrayDeque<>();

        int idx = 0;
        while (idx < sen2.length) {

            if (sen2[idx] == '<') {
                while (!stack.isEmpty()) {
                    out.append(stack.pop());
                }
                out.append(sen2[idx]);
                do {
                    idx++;
                    out.append(sen2[idx]);
                } while (sen2[idx] != '>');
            } else {
                if (sen2[idx] == ' ') {
                    while (!stack.isEmpty()) {
                        out.append(stack.pop());
                    }
                    out.append(' ');
                } else {
                    stack.push(sen2[idx]);
                    if (idx + 1 == sen2.length) {
                        while (!stack.isEmpty()) {
                            out.append(stack.pop());
                        }
                    }
                }
            }
            idx++;
        }
        System.out.println(out);
    }
}