import java.io.*;
import java.util.*;

public class Main {
    public static int k;
    public static int[] topK;
    public static int[] topKCnt;

    public static void findK(int cnt, int num) {

        for (int i = 0; i < k; i++) {
            // 현재 위치보다 우선순위가 높은 경우
            if (cnt > topKCnt[i] ||
                (cnt == topKCnt[i] && num > topK[i])) {

                // 뒤에 있는 원소들을 한 칸씩 밀기
                for (int j = k - 1; j > i; j--) {
                    topKCnt[j] = topKCnt[j - 1];
                    topK[j] = topK[j - 1];
                }

                topKCnt[i] = cnt;
                topK[i] = num;

                break;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        topK = new int[k];
        topKCnt = new int[k];

        int[] arr = new int[n];
        HashMap<Integer, Integer> m = new HashMap<>();


        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : m.entrySet()) {
            int number = entry.getKey();
            int count = entry.getValue();

            findK(count, number);
        }

        for(int num : topK) {
            System.out.print(num + " ");
        }

    }
}