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
        heap_sort(arr, n - 1);

        for(int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;

        int l = i * 2;
        int r = i * 2 + 1;

        if(l <= n && arr[largest] < arr[l]) {
            largest = l;
        }

        if(r <= n && arr[largest] < arr[r]) {
            largest = r;
        }

        if(largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    public static void heap_sort(int[] arr, int n) {
        for(int i = n/2; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for(int i = n; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i - 1, 0);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}