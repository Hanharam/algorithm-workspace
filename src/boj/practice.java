package boj;

import java.util.*;
import java.io.*;


public class practice {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[N + 1];

        for(int i = 1; i <= N; i ++){
            int val = i;
            while(val != 0){
                int num = val % 10;
                val = val / 10;

                cnt[num]++;
            }
        }
        for(int i = 0; i < 10; i++){
            System.out.print(cnt[i] + " ");
        }
    }
}