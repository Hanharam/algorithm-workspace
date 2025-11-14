package boj.math.b14565;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {
    static long x, y;

    static long extended_euclidean(long a, long b){

        if(b == 0){
            x = 1;
            y = 0;
            return a;
        }
        long d = extended_euclidean(b, a % b);
        long xp = x;
        long yp = y;

        x = yp;
        y = xp - (a / b) * yp;
        return d;
    }

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long A = Long.parseLong(st.nextToken());

        long addInv = (N - A) % N;
        long g = extended_euclidean(A, N);

        long mulInv;
        if (g != 1) {
            mulInv = -1;
        }
        else{
            mulInv = (x % N + N) % N;
        }

        System.out.println(addInv + " " + mulInv);

    }
}
