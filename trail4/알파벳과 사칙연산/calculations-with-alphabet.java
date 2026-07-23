import java.io.*;
import java.util.*;

public class Main {
    public static char[] expression;
    public static int n, limit;
    public static ArrayList<Character> alpha;

    public static int[] mapper = new int[129];

    public static int answer = Integer.MIN_VALUE;

    public static void findMax(int cnt) {
        if(cnt == limit) {
            calc();
            return;
        }

        char ch = alpha.get(cnt);
        for(int i = 1; i <= 4; i++) {
            mapper[ch] = i;
            findMax(cnt + 1);
        }

        return;
    }

    public static void calc() {
        int count = 0;

        for(int i = 0; i < n; i++) {
            char ch = expression[i];

            if('a' <= ch && ch <= 'f') {
                count = mapper[ch];
            }
            else {

                if(ch == '+') {
                    i++;
                    count = count + mapper[expression[i]];
                }
                else if(ch == '-') {
                    i++;
                    count = count - mapper[expression[i]];
                }
                else if(ch == '*') {
                    i++;
                    count = count * mapper[expression[i]];
                }
            }
        }

        answer = Math.max(answer, count);
    }

    public static int getCharNum() {
        int[] count = new int[129];
        int cnt = 0;

        for(char ch : expression) {
            if('a' <= ch && ch <= 'f') {
                count[ch]++;
            }
        }

        for(int i = 0; i < count.length; i++) {
            if(count[i] > 0) {
                cnt++;
                alpha.add((char)i);
            }
            
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        expression = br.readLine().toCharArray();

        n = expression.length;

        alpha = new ArrayList<>();

        limit = getCharNum();

        findMax(0);

        System.out.print(answer);
    }
}