package boj.dataStructure.Silver.b1406_에디터;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        String sentence = br.readLine();
        int N = Integer.parseInt(br.readLine());

        int size = sentence.length();

        char[] stackLeft = new char[size + N];
        char[] stackRight = new char[size + N];
        int topLeft = 0;
        int topRight = 0;

        for (int i = 0; i < size; i++) {
            stackLeft[topLeft++] = sentence.charAt(i);
        }


        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            char command = line.charAt(0);

            switch (command){
                case 'L':
                    if (topLeft > 0) {
                        char c = stackLeft[--topLeft];
                        stackRight[topRight++] = c;
                    }
                    break;
                case 'D':
                    if (topRight > 0) {
                        char c = stackRight[--topRight];
                        stackLeft[topLeft++] = c;
                    }
                    break;
                case 'B':
                    if (topLeft > 0) {
                        topLeft--;
                    }
                    break;
                case 'P':
                    char c = line.charAt(2);
                    stackLeft[topLeft++] = c;
                    break;
            }
        }
        while (topLeft > 0) {
            char c = stackLeft[--topLeft];
            stackRight[topRight++] = c;
        }
        while (topRight > 0) {
            char c = stackRight[--topRight];
            out.append(c);
        }
        System.out.println(out);
    }
}
