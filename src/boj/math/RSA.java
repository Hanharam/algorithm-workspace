package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RSA {
    static int x, y;
    public static int toIndex(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 1;
        } else if (c == ' ') {
            return 0;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        if (str.length() % 2 == 1) {
            str += " ";
        }

        int blockCount = str.length()/2;
        int[] blocks = new int[blockCount];

        for(int i = 0; i < blockCount; i++){
            int left = toIndex(str.charAt(2 * i));
            int right = toIndex(str.charAt(2 * i + 1));
            blocks[i] = 100 * left + right;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());



        int[] result = RSA(p, q, e, blocks.length, blocks);
        // 받은 문자를 숫자로 출력
        for (int block : blocks) {
            System.out.printf("%04d", block);
            System.out.print(" ");
        }

        System.out.println();
        for (int res : result) {
            System.out.printf("%04d", res);
            System.out.print(" ");
        }
        int d = extended_euclidean(e, (p - 1) * (q - 1));
        System.out.println();
        System.out.println(x);
    }

    public static int[] RSA(int p, int q, int e, int Array_Size, int[] sentence) {
        int n = p * q;
        int phiN = (p - 1) * (q - 1);
        int[] result = new int[Array_Size];

        for (int i = 0; i < result.length; i++) {
            int m = sentence[i];
            int c = expMod(m, e, n);
            result[i] = c;
        }

        return result;
    }

    public static int expMod(int m, int e, int n) {
        int d;
        if (e == 0) {
            return 1;
        } else if (e % 2 == 0) {
            d = expMod(m, e / 2, n);
            return (d * d) % n;
        } else {
            d = expMod(m, e - 1, n);
            return (m * d) % n;
        }
    }

    static int extended_euclidean(int a, int b){

        if(b == 0){
            x = 1;
            y = 0;
            return a;
        }
        int d = extended_euclidean(b, a % b);
        int xp = x;
        int yp = y;

        x = yp;
        y = xp - (a / b) * yp;
        return d;
    }
}
