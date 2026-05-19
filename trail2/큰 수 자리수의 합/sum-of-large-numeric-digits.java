import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        // Please write your code here.

        int multiple = a * b * c;
        System.out.print(cal(multiple));
    }

    public static int cal(int n) {
        if(n/10 == 0) return n;

        return cal(n/10) + n%10;
    }
} 