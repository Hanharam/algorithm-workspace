import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        System.out.print(cal(n));
    }

    public static int cal(int n) {
        if(n == 1) return 0;

        if(n%2 == 0) return cal(n/2) + 1;
        else return cal(n*3 + 1) + 1;
    }
}