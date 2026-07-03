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
        quick_sort(arr, 0, n - 1);

        for(int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = select_pivot(arr, low, high);
        int i = low - 1;

        for(int j = low; j < high; j++) {
            if(arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    public static int select_pivot(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        int l = arr[low];
        int h = arr[high];
        int m = arr[mid];

        if((m < l && l < h) || (h < l && l < m)) {
            swap(arr, low, high);
            return l;
        }
        else if((l < m && m < h) || (h < m && m < l)) { 
            swap(arr, mid, high);
            return m;
        }
        else {
            return h;
        }

    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void quick_sort(int[] arr, int low, int high) {
        if(low < high) {
            int pos = partition(arr, low, high);
        

            quick_sort(arr, low, pos - 1);
            quick_sort(arr, pos + 1, high);
        }
    }
}