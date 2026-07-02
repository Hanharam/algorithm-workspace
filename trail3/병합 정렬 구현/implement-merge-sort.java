import java.util.Scanner;

public class Main {

    public static int[] merged_arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        merged_arr = new int[n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        merge_sort(arr, 0, n - 1);

        for(int num : arr) {
            System.out.print(num + " ");
        }
    }


    public static void merge_sort(int[] arr, int low, int high) {
        if(low < high) {
            int mid = (low + high) / 2;
            merge_sort(arr, low, mid);
            merge_sort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = low;
        while(i <= mid && j <= high) {
            if(arr[i] <= arr[j]) {
                merged_arr[k] = arr[i];
                k++;
                i++;
            }
            else {
                merged_arr[k] = arr[j];
                k++;
                j++;
            }
        }

        while(i <= mid) {
            merged_arr[k++] = arr[i++];
        }
        while(j <= high) {
            merged_arr[k++] = arr[j++];
        }

        for(int l = low; l <= high; l++) {
            arr[l] = merged_arr[l];
        }
    }
}