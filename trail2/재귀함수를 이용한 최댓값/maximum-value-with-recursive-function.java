import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int curidx = n - 1;
        int maxidx = n - 1;

        System.out.print(arr[find_max(arr, curidx, maxidx)]);
    }

    public static int find_max(int[] arr, int curidx, int maxidx) {
        if(curidx < 0) return maxidx;

        if(arr[curidx] > arr[maxidx]) { return find_max(arr, curidx - 1, curidx);}
        else {return find_max(arr, curidx - 1, maxidx);}
    }
}