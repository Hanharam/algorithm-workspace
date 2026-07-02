import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        
        ArrayList<Integer>[] buckets = new ArrayList[10];
        for(int i= 0; i < 10; i++) {
            buckets[i] = new ArrayList<>();
        }

        for(int i = 0; i < 6; i++) {

            for(int j = 0; j < n; j++) {
                int num = arr[j];
                for(int k = 0; k < i; k++) {
                    num = num/10;
                }
                num = num % 10;

                buckets[num].add(arr[j]);
            }


            int idx = 0;
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k < buckets[j].size(); k++) {
                    arr[idx++] = buckets[j].get(k);
                }
                buckets[j].clear();
            }
        }

        for(int num : arr) {
            System.out.print(num + " ");
        }
    }
}