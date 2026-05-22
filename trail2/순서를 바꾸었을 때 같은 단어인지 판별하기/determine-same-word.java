import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word1 = br.readLine();
        String word2 = br.readLine();

        char[] charList1 = word1.toCharArray();
        char[] charList2 = word2.toCharArray();

        Arrays.sort(charList1);
        Arrays.sort(charList2);

        System.out.print(Arrays.equals(charList1, charList2)? "Yes" : "No");
    }
}