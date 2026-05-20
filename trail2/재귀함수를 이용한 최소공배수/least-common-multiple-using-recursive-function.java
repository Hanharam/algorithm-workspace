import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.
        System.out.print(total_lcm(arr, n - 1));
    }

    public static int total_lcm(int[] arr, int n) {
        if(n == 0) return arr[0];
        return lcm(arr[n], total_lcm(arr, n - 1));
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return(gcd(b, a%b));
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
