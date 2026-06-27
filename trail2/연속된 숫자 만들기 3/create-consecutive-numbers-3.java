import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[3];

        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int dist = Math.max(arr[2] - arr[1], arr[1] - arr[0]);
        System.out.print(dist - 1);
    }
}

// 10 16 20
// 10 11 12
// 10 11 15
// 11 12 15
// 12 13 15
// 13 14 15

// 14 15 16

// 10 12 14