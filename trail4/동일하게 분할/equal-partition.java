import java.io.*;
import java.util.*;

public class Main {
    public static int n, totalSum;
    public static int[] arr = new int[101];

    public static final int OFFSET = 100000;
    
    public static boolean[] prev = new boolean[200005];

    public static void init() {
        int x = arr[1];
        prev[OFFSET + x] = true;
        prev[OFFSET - x] = true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            totalSum += arr[i];
        }

        init();

        for(int i = 2; i <= n; i++) {
            int x = arr[i];
            boolean[] curr = new boolean[200005]; // 현재 단계의 상태를 저장할 배열

            for(int j = OFFSET - totalSum; j <= OFFSET + totalSum; j++) {
                if(prev[j]) {
                    // 1. A 그룹
                    if(j + x <= 2 * OFFSET)
                        curr[j + x] = true;

                    // 2. B 그룹
                    if(j - x >= 0) {
                        curr[j - x] = true;
                    }
                }
            }
            prev = curr; 
        }

        if(prev[OFFSET]) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
}