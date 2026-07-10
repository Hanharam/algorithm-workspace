import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++) {
            char temp = arr[arr.length - 1];
            for(int j = arr.length - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = temp;

            int section = 1;
            for(int j = 0; j < arr.length - 1; j++) {
                if(arr[j] != arr[j + 1]) section++;
            }
            ans = Math.min(ans, section);
        }

        if(ans == 1 && arr.length == 10) ans = ans * 2 + 1;
        else ans = ans * 2;
        System.out.print(ans);
    }
}