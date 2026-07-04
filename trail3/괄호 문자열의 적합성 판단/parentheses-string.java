import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        // Please write your code here.

        char[] arr = str.toCharArray();

        char[] stack = new char[arr.length];
        int top = 0;

        for(char c : arr) {
            if(c == '(') {
                stack[top++] = c;
            }
            else if(c == ')') {
                if(top == 0) {
                    System.out.println("No");
                    return;}
                
                top = top - 1;
            }
        }

        if(top != 0) System.out.println("No");
        else System.out.println("Yes");
    }
}