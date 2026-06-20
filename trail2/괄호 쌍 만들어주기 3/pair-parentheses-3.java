import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        int sum = 0;
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            if(arr[i] == '(') {
                for(int j = i + 1; j < n; j++) {
                    if(arr[j] == ')') sum++;
                }
            }
        }

        System.out.print(sum);
    }
}

//  ( 이거 찾은 후 ) 이거 개수 구하기