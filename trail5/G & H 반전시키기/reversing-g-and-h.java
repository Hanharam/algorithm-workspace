import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[] init = br.readLine().toCharArray();
        char[] goal = br.readLine().toCharArray();

        boolean[] arr = new boolean[init.length];

        for(int i = 0; i < init.length; i++) {
            if(init[i] == goal[i]) arr[i] = true;
            else arr[i] = false;
        }

        int answer = 0;
        for(int i = 0; i < init.length - 1; i++) {
            if(arr[i] == false && arr[i + 1] == true) answer++;
        }

        if(!arr[init.length - 1]) answer++;

        System.out.print(answer);

    }
}